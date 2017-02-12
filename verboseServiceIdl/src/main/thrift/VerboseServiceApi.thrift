namespace java com.github.laysakura.quilldebuglog.idl

service VerboseService {
  string echo(
    1: i64 userId
    2: string message
  )
}
