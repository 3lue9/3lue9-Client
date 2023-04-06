package cf.vaccat.catclient.module.utils.menu.tools;


import cf.vaccat.catclient.CatClient;
import cf.vaccat.catclient.module.utils.menu.TutorialMenu;
import net.minecraft.client.Minecraft;
import net.minecraft.util.Session;
import com.mojang.authlib.Agent;
import com.mojang.authlib.yggdrasil.YggdrasilAuthenticationService;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.GuiTextField;
import org.lwjgl.input.Keyboard;
import org.lwjgl.opengl.GL11;
import com.mojang.authlib.AuthenticationService;
import com.mojang.authlib.UserAuthentication;
import com.mojang.authlib.minecraft.MinecraftSessionService;
import java.util.UUID;
import java.awt.*;
import java.io.IOException;


public class ChangeUser extends GuiScreen {
    GuiTextField inputField;
    public static UUID uuid;
    public static AuthenticationService authService;
    public static UserAuthentication auth;
    public static MinecraftSessionService sessionService;

    @Override
    public void initGui() {
        int i = this.height / 4 + 48;

        this.buttonList.clear();

        inputField = new GuiTextField(1, fontRenderer, this.width / 2 - 100, i + 72 - 12, 200, 20);
        inputField.setText("Username");

        this.buttonList.add(new GuiButton(1, this.width / 2 - 100, i + 72 + 12, 200, 20, "Login"));
    }

    public static void changeName(String name) {

        uuid = UUID.randomUUID();
        authService = new YggdrasilAuthenticationService(Minecraft.getMinecraft().getProxy(), uuid.toString());
        auth = authService.createUserAuthentication(Agent.MINECRAFT);
        sessionService = authService.createMinecraftSessionService();

        Session session = new Session(name, name, "1", "legacy");

        try {
            CatClient.setSession(session);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void actionPerformed(GuiButton button) throws IOException {
        if (button.id == 1) {
            changeName(inputField.getText());
        }
    }

    @Override
    public void updateScreen() {
        inputField.updateCursorCounter();
    }

    @Override
    protected void keyTyped(char typedChar, int keyCode) throws IOException {
        switch (keyCode) {
            case Keyboard.KEY_ESCAPE:
                mc.displayGuiScreen(new TutorialMenu());
                break;
            default:
                inputField.textboxKeyTyped(typedChar, keyCode);
        }
    }

    @Override
    protected void mouseClicked(int mouseX, int mouseY, int mouseButton) throws IOException {
        inputField.mouseClicked(mouseX, mouseY, mouseButton);
        super.mouseClicked(mouseX, mouseY, mouseButton);
    }

    @Override
    public void drawScreen(int mouseX, int mouseY, float partialTicks) {
        GL11.glColor4f(1, 1, 1, 1);
        drawDefaultBackground();

        for (int i = 0; i < this.buttonList.size(); i++) {
            ((GuiButton) this.buttonList.get(i)).drawButton(this.mc, mouseX, mouseY, partialTicks);
        }

        inputField.drawTextBox();
        mc.fontRenderer.drawStringWithShadow("Your Username: " + mc.getSession().getUsername(), this.width / 2 - 100, this.height / 4 + 48 + 110, Color.yellow.getRGB());
    }
}


