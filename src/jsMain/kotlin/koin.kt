import components.busyPopupModule
import dev.fritz2.core.RenderContext
import dev.fritz2.core.render
import dev.fritz2.core.storeOf
import kotlinx.coroutines.Job
import localization.TranslationStore
import org.koin.core.Koin
import org.koin.core.context.GlobalContext
import org.koin.core.context.startKoin
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module

inline fun <T> withKoin(block: Koin.() -> T): T = with(GlobalContext.get()) {
    block(this)
}

suspend fun startAppWithKoin(ui: RenderContext.()->Unit) {
    startKoin {
        modules(
            cookiePermissionModule,
            busyPopupModule,
//            routingModule,
//            settingsModule,
//            fileLoaderModule,
//            translationServiceModule,
        )
    }
    withKoin {
        // load is a suspend function
        // so we declare this component last
        declare(TranslationStore.load(storeOf("en-US", Job()), fallback = "en-US"))

        val cookiePermissionStore = get<CookiePermissionStore>()
        cookiePermissionStore.awaitLoaded() // prevents flashing the cookie screen before we load the settings from local storage

        render("#target", content=ui)
    }
}
