import java.security.Key
import javax.crypto.Cipher
import javax.crypto.Cipher.*
import javax.crypto.SecretKey
import javax.crypto.spec.IvParameterSpec
import javax.crypto.spec.SecretKeySpec
import kotlin.io.encoding.Base64
import kotlin.io.encoding.ExperimentalEncodingApi

/** Объект, позволяющий шифровать сообщения и расшифровывать их */
object Encryptor {
    private val password = "ASDFGHEYVN47CB4F"

    /** Производит шифрование строки согласно протоколу AES
     * @return зашифрованную строку **/
    @OptIn(ExperimentalEncodingApi::class)
    fun encryptThis(input: String): String {
        // Создаем объект шифра
        val cipher = Cipher.getInstance("AES")

        // Создает уникальный ключ и инициализируем шифр
        val keySpec = SecretKeySpec(password.toByteArray(), "AES")
        cipher.init(Cipher.ENCRYPT_MODE, keySpec)

        // Шифруем и возвращаем зашифрованное
        val encrypt = cipher.doFinal(input.toByteArray())
        return Base64.encode(encrypt)
    }

    /** Производит расшифрование строки согласно протоколу AES
     * @return расшифрованную строку **/
    @OptIn(ExperimentalEncodingApi::class)
    fun decrypt(input: String): String {
        // Создаем объект шифра
        val cipher = Cipher.getInstance("AES")

        // Создает уникальный ключ и инициализируем шифр
        val keySpec = SecretKeySpec(password.toByteArray(), "AES")
        cipher.init(Cipher.DECRYPT_MODE, keySpec)

        // Расшифруем и возвращаем
        val encrypt = cipher.doFinal(Base64.decode(input))
        return String(encrypt)
    }
}