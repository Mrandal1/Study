package study.chapter04;

/**
 * @author Randal1
 * @version V1.0
 * @Package study.chapter04
 * @data 2020/4/25 15:55
 */
public class PetShop {
    private ILink<Pet> allpets = new LinkImpl<>();

    public void addPet(Pet pet) {
        allpets.add(pet);
    }

    public void del(Pet pet) {
        allpets.remove(pet);
    }

    public ILink<Pet> search(String key) {
        ILink<Pet> petResult = new LinkImpl<>();
        Object[] result = this.allpets.toArray();
        if (result != null) {
            for (Object obj : result) {
                Pet pet = (Pet) obj;
                if ((pet.getName().contains(key)) || pet.getColor().contains(key)) {
                    petResult.add(pet);
                }
            }
        }
        return petResult;
    }
}
