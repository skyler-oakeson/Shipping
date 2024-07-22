import Mappers.FileMapper
import Mappers.FileType
import org.testng.Assert.assertEquals
import org.testng.Assert.assertNotNull
import org.testng.annotations.Test

class FileMapperTest {
    @Test
    fun testFileMapperConstruct() {
        assertNotNull(FileMapper(FileType.CSV, "src/test/kotlin/test-file.txt", "1", "2", "3", "4"))
    }

    @Test
    fun testInvalidPath() {
         { FileMapper(FileType.CSV, "test-file.txt", "1", "2", "3", "4") }
    }

    @Test
    fun testFileMapperCsv() {
        val fileMapper = FileMapper(FileType.CSV, "src/test/kotlin/test-file.txt", "1", "2", "3", "4")
        assertEquals(mapOf(Pair("1", "valid"), Pair("2", "100"), Pair("3", "100"), Pair("4", "100")), fileMapper.mapNextLine())
        assertEquals(mapOf(Pair("1", "valid"), Pair("2", "100")), fileMapper.mapNextLine())
    }
}