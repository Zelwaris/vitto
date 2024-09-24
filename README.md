# Vitto

This project is mostly a little side project with the intent of just having something to do when bored.
I wouldn't recommend actually using it.

### What is it?

It's a CLI tool which combines both yt-dlp and ffmpeg and simplifies their usage.

### Developing

Since the plan is to have it be a CLI tool, I've decided to use GraalVM to make a native binary.

Simply run: `./mvnw -Pnative package` to create a binary.