import com.tryformation.localization.Translatable
import localization.translate

suspend fun main() {
    // starts up koin and initializes the TranslationStore
    startAppWithKoin {
        h1("text-red-700 p-5") {
            translate(DefaultLangStrings.Hello)
        }
        p {
            +"HAIAIA"
        }
    }
}

// you can use enums for translatable strings
enum class DefaultLangStrings : Translatable {
    Hello,
    ;

    override val prefix: String
        get() = "default"
}
