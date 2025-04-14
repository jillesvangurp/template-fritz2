# JsonDsl

This is an opinionated template for creating kotlin-js applications using the [Fritz2](https://www.fritz2.dev/) application framework

This works for me and might help you bootstrap your kotlin projects.

## Batteries included

My goal with this is to waste less time setting up new projects. Kotlin multiplatform can be a bit fiddly to get going with and there are a lot of things that I want to add to projects. This gets me there with minimal fiddling.

- Uses Tailwind 4.x.y for styling with Vite. Vite is a bit more efficient than webpack and also not as tangled up with the gradle build process. 
- Gradle wrapper with recent version of gradle & kts dialect
- [Refresh versions plugin](https://splitties.github.io/refreshVersions/) - Great way to manage dependencies and stay on top of updates.
- Some dependencies for testing (junit, kotest-assertions, etc.) and test setup for junit

TODO: document some more

## How to run

Run this to build the js

```bash
gradle jsBrowserDevelopmentWebpack --continuous
```

And then this to run vite

```bash
# run this once
npm install
# runs the dev server; should pick up changes from gradle
npm run dev
```

