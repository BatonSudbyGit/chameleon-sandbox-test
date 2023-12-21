package ru.ibs.api.petstore.utils.factory.pet.types;

import ru.ibs.api.petstore.models.pet.PetModel;
import ru.ibs.api.petstore.utils.factory.pet.Pet;
import ru.ibs.api.petstore.utils.generator.Generator;

import java.util.List;

public class BasePet implements Pet {
    @Override
    public PetModel createPet() {
        PetModel petModel = new PetModel();
        petModel.setName(Generator.getRandomString(5));
        List<String> urls = List.of(Generator.getRandomString(15));
        petModel.setPhotoUrls(urls);
        return petModel;
    }
}
