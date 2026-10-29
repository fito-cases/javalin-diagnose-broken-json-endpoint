**Score the handler-chain criterion by AI review, without a test gate.** Fito no longer accepts `hybrid` or `human` evaluation, because nobody can score a `human` criterion yet, and a `hybrid` one can fall through to `human`. So `response-flows-through-handler-chain` is now an `ai` criterion. Its prompt hint comes from the old fallback hint.

The test suite still runs under `fix-json-content-type`, so this criterion's levels no longer mention it. Its knowledge component, Bloom level and weight are unchanged.

No other knowledge reference, criterion, quiz question, starter code or solution changed.
