import com.tryformation.localization.Translatable
import localization.translate

suspend fun main() {
    startAppWithKoin {
        h1 {
            translate(DefaultLangStrings.Hello)
        }
    }
}

enum class DefaultLangStrings : Translatable {
    Hello,
    ;

    override val prefix: String
        get() = "default"
}
