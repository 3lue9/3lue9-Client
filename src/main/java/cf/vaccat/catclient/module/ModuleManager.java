package cf.vaccat.catclient.module;

import java.util.ArrayList;


import cf.vaccat.catclient.module.combat.*;
import cf.vaccat.catclient.module.hud.FPS;
import cf.vaccat.catclient.module.hud.ModuleArray;
import cf.vaccat.catclient.module.hud.UserName;
import cf.vaccat.catclient.module.hud.WaterMark;
import cf.vaccat.catclient.module.movement.*;
import cf.vaccat.catclient.module.render.*;
import cf.vaccat.catclient.module.exploits.*;
import cf.vaccat.catclient.module.render.ESP.ChestESP;
import cf.vaccat.catclient.module.render.ESP.PlayerESP;


public class ModuleManager {

	public ArrayList<Module> modules;
	
	public ModuleManager() {
		(modules = new ArrayList<Module>()).clear();

		// Render
		this.modules.add(new ClickGUI());
		this.modules.add(new NameTags());
		this.modules.add(new FullBright());
		this.modules.add(new ChestESP());
		this.modules.add(new PlayerESP());

		// Movement
		this.modules.add(new Sprint());
		this.modules.add(new Bhop());
		this.modules.add(new Speed());
		this.modules.add(new Jesus());
		this.modules.add(new DamageBoost());
		this.modules.add(new Fly());


		// Combat
		this.modules.add(new Velocity());
		this.modules.add(new AutoClicker());

		// Exploits
		this.modules.add(new FakeCreative());

		// HUD
		this.modules.add(new WaterMark());
		this.modules.add(new UserName());
		this.modules.add(new FPS());
		this.modules.add(new ModuleArray());

	}

	public Module getModule(String name) {
		for (Module m : this.modules) {
			if (m.getName().equalsIgnoreCase(name)) {
				return m;
			}
		}
		return null;
	}
	
	public ArrayList<Module> getModuleList() {
		return this.modules;
	}
	
	public ArrayList<Module> getModulesInCategory(Category c) {
		ArrayList<Module> mods = new ArrayList<Module>();
		for (Module m : this.modules) {
			if (m.getCategory() == c) {
				mods.add(m);
			}
		}
		return mods;
	}
}
