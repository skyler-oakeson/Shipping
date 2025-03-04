package Mappers

class CsvMapper(vararg fields: String): MappingStrategy(*fields) {
    override fun mapString(line: String) : Map<String, String>  {
        val words = line.trim(' ').split(',')

        if (words.size > keys.size) {
            throw Exception("Not enough keys to accommodate number of columns.")
        }

        val parsed = mutableMapOf<String, String>()
        words.forEachIndexed { index, word ->
            keys[index].let { parsed[it] = word }
        }
        return parsed
    }
}
