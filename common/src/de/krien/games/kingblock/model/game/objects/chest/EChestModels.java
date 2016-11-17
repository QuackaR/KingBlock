package de.krien.games.kingblock.model.game.objects.chest;

import de.krien.games.kingblock.model.IEntityModel;

public enum EChestModels implements IEntityModel {

    CRATE_01("CHEST_01"),
    CRATE_02("CHEST_02"),
    CRATE_03("CHEST_03"),
    MILITARY_CHEST_01("CHEST_04"),
    MILITARY_CHEST_02("CHEST_05");

    private static final String type = "chest";
    private String modelID;

    EChestModels(String modelID) {
        this.modelID = modelID;
    }

    public String getModelID() {
        return modelID;
    }
    public String getType() {
        return type;
    }
}
