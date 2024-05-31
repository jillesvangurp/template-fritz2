# JsonDsl

This is an opinionated template for creating kotlin-js applications using the [Fritz2](https://www.fritz2.dev/) application framework

This works for me and might help you bootstrap your kotlin projects.

## Batteries included

My goal with this is to waste less time setting up new projects. Kotlin multiplatform can be a bit fiddly to get going with and there are a lot of things that I want to add to projects. This gets me there with minimal fiddling.

- Gradle wrapper with recent version of gradle & kts dialect
- [Refresh versions plugin](https://splitties.github.io/refreshVersions/) - Great way to manage dependencies and stay on top of updates.
- Some dependencies for testing (junit, kotest-assertions, etc.) and test setup for junit
- generic publish script that tags and publishes (you'll want to adjust this)
- Github action that builds your stuff generated using [github-workflows-kt](https://github.com/typesafegithub/github-workflows-kt). Setup to cache gradle and konan related files to speed up your builds.
- LICENSE file (MIT)

## Usage & project create checklist

- [ ] Go to Github and push the "Use this template" button. This will create a new project based on this template
- [ ] Fix your project name by changing `rootProject.name` in settings.gradle.kts. Override the group name in gradle.properties
- [ ] Modify index.html to have a title and to load the correct js file matching the name in settings.gradle.kts.
- [ ] Review default maven repo for releases and other things in build.gradle.kts
- [ ] Update copyright file
- [ ] Start writing your own README.md by modifying the code that generates it

## Development

```bash
# run application on port 8080
./gradlew jsBrowserDevelopmentRun -t

# production artifacts
./gradlew jsBrowserProductionWebpack
```