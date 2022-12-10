package cf.vaccat.catclient.module;

import java.util.ArrayList;

import cf.vaccat.catclient.module.combat.*;
import cf.vaccat.catclient.module.movement.*;
import cf.vaccat.catclient.module.render.*;
import cf.vaccat.catclient.module.exploits.*;

public class ModuleManager {

	public ArrayList<Module> modules;
	
	public ModuleManager() {
		(modules = new ArrayList<Module>()).clear();

		// Render
		this.modules.add(new ClickGUI());
		this.modules.add(new HUD());
		this.modules.add(new NameTags());
		this.modules.add(new FullBright());

		// Movement
		this.modules.add(new Sprint());
		this.modules.add(new Bhop());
		this.modules.add(new Speed());
		this.modules.add(new Jesus());
		//this.modules.add(new Fly());

		// Combat
		this.modules.add(new Velocity());

		// Exploits
		this.modules.add(new FakeCreative());
		// HUD

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
