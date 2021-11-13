package chapter4

import chapter4.Problem7.solve
import org.junit.Assert.assertThrows
import org.junit.Test
import kotlin.test.fail

class Problem7Tests {

    @Test
    fun `Example from exercise`() {
        val inputProjects = listOf('a', 'b', 'c', 'd', 'e', 'f')
        val dependencies = mutableListOf(
            'a' to 'd',
            'f' to 'b',
            'b' to 'd',
            'f' to 'a',
            'd' to 'c'
        )
        checkTestCase(inputProjects, dependencies, false)
    }

    @Test
    fun `Cyclic dependency`() {
        val inputProjects = listOf('a', 'b', 'c', 'd', 'e', 'f')
        val dependencies = mutableListOf(
            'a' to 'b',
            'b' to 'c',
            'c' to 'd',
            'd' to 'e',
            'e' to 'f',
            'f' to 'a'
        )
        checkTestCase(inputProjects, dependencies, true)
    }

    private fun checkTestCase(inputProjects: List<Char>, dependencies: List<Pair<Char, Char>>, expectError: Boolean) {
        if (expectError) assertThrows(Problem7.ImpossibleBuildError::class.java) { solve(inputProjects, dependencies) }
        else checkSolution(inputProjects, dependencies)
    }

    private fun checkSolution(inputProjects: List<Char>, dependencies: List<Pair<Char, Char>>) {
        val solution = solve(inputProjects, dependencies)
        val deps = dependencies.toMutableList()
        val proj = inputProjects.toMutableList()

        solution.forEach { build ->
            if (!proj.contains(build)) fail("This is not a build that still needs to be build or it doesn't exist")
            if (deps.any { it.second == build }) fail("This build still had a dependency")
            else {
                deps.removeIf { it.first == build }
                proj.remove(build)
            }
        }
        if (proj.isNotEmpty()) fail("There were still projects left to be build")
    }
}