import com.tryformation.localization.Translatable
import localization.Locales
import localization.TranslationStore
import localization.translate

suspend fun main() {
    // starts up koin and initializes the TranslationStore
    startAppWithKoin {
        article("p-5") {
            h1("text-red-700") {
                translate(DefaultLangStrings.PageTitle)
            }
            p {
                translate(DefaultLangStrings.WelcomeText)
            }

            // here's how you do stuff with the translation store
            withKoin {
                val translationStore = get<TranslationStore>()
                translationStore.data.render {currentBundle ->
                    val currentLocale = currentBundle.bundles.first().locale.first()
                    div("flex flex-row gap-2.5") {
                        Locales.entries.forEach {locale ->
                            if(currentLocale == locale.title) {
                                p {
                                    em {
                                        +locale.title
                                    }
                                }
                            } else {
                                a {
                                    +locale.title
                                    clicks handledBy {
                                        translationStore.updateLocale(locale.title)
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}

// you can use enums for translatable strings
enum class DefaultLangStrings : Translatable {
    PageTitle,
    WelcomeText,
    ;

    // fluent files have identifiers with this prefix and the camel
    // case of the enum value converted to lower case with dashes.
    override val prefix: String
        get() = "default"
}
