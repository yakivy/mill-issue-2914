# mill-issue-2914
## Steps to reproduce
- `./mill __.publishLocal`
- update `def apply(a: String): Unit` to `def apply(a: Int): Unit`
- update `Api1.apply("qwe")` to `Api1.apply(1)`
- `./mill __.compile` finish successfully
- update Mill version to `0.11.6`
- `./mill clean`
- `./mill __.compile` fails