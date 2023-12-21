package ru.ibs.api.petstore.utils.factory.pet;

import org.junit.jupiter.api.Assertions;
import ru.ibs.api.petstore.models.pet.PetModel;
import ru.ibs.api.petstore.utils.factory.enums.PetTypeVar;
import ru.ibs.api.petstore.utils.factory.pet.types.BasePet;
import ru.ibs.api.petstore.utils.factory.pet.types.FullPet;

public class PetFactory {
    public static PetModel createNewPet(PetTypeVar petTypeVar) {
        switch (petTypeVar) {
            case BASE_PET:
                return new BasePet().createPet();
            case FULFILLED_PET:
                return new FullPet().createPet();
            default:
                Assertions.fail(petTypeVar + " is unknown");
        }
        return null;
    }
}
