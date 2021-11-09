package chapter3

object Problem6 {

    class AnimalShelter() {

        sealed class AnimalNode (val name: String){
            var prevAnimal: AnimalNode? = null
            var nextAnimal: AnimalNode? = null

            class CatNode(name: String) : AnimalNode(name){
                var prevCat: CatNode? = null
                var nextCat: CatNode? = null
            }

            class DogNode(name: String) : AnimalNode(name){
                var prevDog: DogNode? = null
                var nextDog: DogNode? = null
            }
        }

        var animalFirst : AnimalNode? = null
        var animalLast: AnimalNode? = null
        var catFirst : AnimalNode.CatNode? = null
        var catLast: AnimalNode.CatNode? = null
        var dogFirst : AnimalNode.DogNode? = null
        var dogLast: AnimalNode.DogNode? = null


        fun add(animal: AnimalNode) {
            if (animalFirst == null){
                animalFirst = animal
                animalLast = animal
            } else {
                animalLast?.nextAnimal = animal
                animal.prevAnimal = animalLast
                animalLast = animal
            }

            when(animal){
                is AnimalNode.CatNode -> addCat(animal)
                is AnimalNode.DogNode -> addDog(animal)
            }
        }

        private fun addCat(animal: AnimalNode.CatNode){
            if (catFirst == null) {
                catFirst = animal
                catLast = animal
            } else {
                catLast?.nextCat = animal
                animal.prevCat = catLast
                catLast = animal
            }
        }

        private fun addDog(animal: AnimalNode.DogNode){
            if (dogFirst == null) {
                dogFirst = animal
                dogLast = animal
            } else {
                dogLast?.nextDog = animal
                animal.prevDog = dogLast
                dogLast = animal
            }
        }


        fun remove(): AnimalNode {
            if (animalFirst == null) throw NoSuchElementException()
            return when (animalFirst){
                is AnimalNode.CatNode -> removeCat()
                else -> removeDog()
            }
        }

        fun removeCat() : AnimalNode.CatNode {
            if (catFirst == null) throw NoSuchElementException()
            val returnVal = catFirst!!

            if (catFirst == animalFirst) animalFirst = animalFirst?.nextAnimal
            if (catFirst == animalLast) animalLast = animalLast?.prevAnimal
            if (returnVal.prevAnimal != null) returnVal.prevAnimal?.nextAnimal = returnVal.nextAnimal
            if (returnVal.nextAnimal != null) returnVal.nextAnimal?.prevAnimal = returnVal.prevAnimal

            if (returnVal == catLast) catLast = null
            catFirst = returnVal.nextCat
            return returnVal
        }

        fun removeDog() : AnimalNode.DogNode {
            if (dogFirst == null) throw NoSuchElementException()
            val returnVal = dogFirst!!

            if (dogFirst == animalFirst) animalFirst = animalFirst?.nextAnimal
            if (dogFirst == animalLast) animalLast = animalLast?.prevAnimal
            if (returnVal.prevAnimal != null) returnVal.prevAnimal?.nextAnimal = returnVal.nextAnimal
            if (returnVal.nextAnimal != null) returnVal.nextAnimal?.prevAnimal = returnVal.prevAnimal

            if (returnVal == dogLast) dogLast = null

            dogFirst = returnVal.nextDog
            return returnVal
        }

    }
}