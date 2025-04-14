package localization

// a language selector could work like this.

//fun RenderContext.languageSelector() {
//    withKoin {
//        val translationStore = get<TranslationStore>()
//        p {
//            translate(TL.LanguageSelector.SelectLanguage)
//        }
//        translationStore.data.render { bundleSequence ->
//            selectComponent {
//                changes handledBy { selected ->
//                    val element = selected.target as HTMLSelectElement
//                    val selectedLanguage = element.value
//                    console.log("Setting language to $selectedLanguage")
//                    translationStore.updateLocale(selectedLanguage)
//                }
//                Locales.entries.sorted().forEach { locale ->
//                    option {
//                        +locale.title
//                        val current = bundleSequence.bundles.first().locale.first()
//                        if (current.equals(locale.title, true)) {
//                            selected(true)
//                        }
//                    }
//                }
//            }
//        }
//    }
//}
