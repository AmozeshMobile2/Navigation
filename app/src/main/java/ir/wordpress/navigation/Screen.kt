package ir.wordpress.navigation

sealed class Screen(val route: String) {

    object Home : Screen("home")
    object DetailScreen : Screen("DetailScreen")


    fun withArgs(vararg args: String) :String {

        return buildString {
            append(route)
            args.forEach {args ->
                append("/$args")
            }

        }


    }

}