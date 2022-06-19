# Sentry-Exception-Handling
Learn how you can gracefully handle exceptions in android.

[Sentry SDK][sentry-android] is used to capture and report the exceptions.

To capture exceptions in your Sentry project replace `https://examplePublicKey@o0.ingest.sentry.io/0` in `AndroidManifest.xml`.
Follow this to find your [DSN][dsn]

```
<meta-data android:name="io.sentry.dsn" android:value="https://examplePublicKey@o0.ingest.sentry.io/0" />
```
 

[sentry-android]: https://sentry.io/for/android/
[dsn]: https://docs.sentry.io/product/sentry-basics/dsn-explainer/#where-to-find-your-dsn
