package ru.ibs.api.petstore.utils.factory.pet.types;

import ru.ibs.api.petstore.models.pet.Category;
import ru.ibs.api.petstore.models.pet.PetModel;
import ru.ibs.api.petstore.models.pet.Tag;
import ru.ibs.api.petstore.utils.factory.pet.Pet;
import ru.ibs.api.petstore.utils.generator.Generator;

import java.util.List;
import java.util.Random;

public class FullPet implements Pet {
    @Override
    public PetModel createPet() {
        Category category = new Category();
        category.setId(new Random().nextInt(300));
        category.setName(Generator.getRandomString(5));

        Tag tag = new Tag();
        tag.setId(41556);
        tag.setName(Generator.getRandomString(5));

        PetModel petModel = new PetModel();
        petModel.setCategory(category);
        petModel.setId(new Random().nextLong());
        petModel.setName(Generator.getRandomString(5));
        List<String> urls = List.of(Generator.getRandomString(15));
        petModel.setPhotoUrls(urls);
        petModel.setTags(List.of(tag));
        petModel.setStatus(Generator.getRandomStatus());

        return petModel;
    }
}
