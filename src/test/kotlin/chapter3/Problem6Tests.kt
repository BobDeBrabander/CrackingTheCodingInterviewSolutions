package chapter3

import org.junit.Assert.assertThrows
import org.junit.Test
import kotlin.test.assertEquals

class Problem6Tests {

    @Test
    fun `test case`() {
        val animalShelter = Problem6.AnimalShelter()

        val dog1 = Problem6.AnimalShelter.AnimalNode.DogNode("kees")
        val dog2 = Problem6.AnimalShelter.AnimalNode.DogNode("jaap")
        val dog3 = Problem6.AnimalShelter.AnimalNode.DogNode("fred")
        val dog4 = Problem6.AnimalShelter.AnimalNode.DogNode("henk")

        val cat1 = Problem6.AnimalShelter.AnimalNode.CatNode("laura")
        val cat2 = Problem6.AnimalShelter.AnimalNode.CatNode("adriana")
        val cat3 = Problem6.AnimalShelter.AnimalNode.CatNode("kashmira")
        val cat4 = Problem6.AnimalShelter.AnimalNode.CatNode("maria")

        animalShelter.add(dog1)
        animalShelter.add(cat1)
        animalShelter.add(cat2)
        animalShelter.add(dog2)
        animalShelter.add(dog3)
        animalShelter.add(dog4)
        animalShelter.add(cat3)
        animalShelter.add(cat4)

        // kees - laura - adriana - jaap - fred - henk - kashmira - maria
        assertEquals("kees", animalShelter.remove().name)

        // laura - adriana - fred - henk - kashmira - maria
        assertEquals("jaap", animalShelter.removeDog().name)

        // laura - adriana - fred - henk - kashmira - maria
        assertEquals("laura", animalShelter.remove().name)

        // adriana - fred - henk - kashmira - maria
        assertEquals("adriana", animalShelter.remove().name)

        // fred - henk - kashmira - maria
        assertEquals("fred", animalShelter.remove().name)

        // henk - kashmira - maria
        assertEquals("kashmira", animalShelter.removeCat().name)

        // henk - maria
        assertEquals("maria", animalShelter.removeCat().name)

        // henk
        assertThrows(NoSuchElementException::class.java) { animalShelter.removeCat() }
        assertEquals("henk", animalShelter.remove().name)

        // empty
        assertThrows(NoSuchElementException::class.java) { animalShelter.removeDog() }
        assertThrows(NoSuchElementException::class.java) { animalShelter.remove() }
    }


}