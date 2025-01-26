package iss.nus.edu.sg.sa4106.kebunjio.service

import android.app.Service
import android.content.Intent
import android.os.Environment
import android.os.IBinder
import java.io.File
import java.io.FileOutputStream
import java.io.InputStream
import java.net.HttpURLConnection
import java.net.URL
import java.util.UUID

class DownloadImageService : Service() {
    override fun onStartCommand(intent: Intent, flags: Int, startId: Int): Int {
        if (intent.action.equals("download_file")) {
            val url = intent.getStringExtra("url")
            if (url != null) {
                startImageDownload(url)
            }
        }

        return super.onStartCommand(intent, flags, startId)
    }

    protected fun startImageDownload(imgURL: String) {
        val ext = getFileExtension(imgURL)
        val file = createDestFile(ext)

        // creating and starting a background thread
        Thread {
            if (downloadImage(imgURL, file)) {
                val intent = Intent()
                intent.setAction("download_completed")
                intent.putExtra("filename", file.absolutePath)

                sendBroadcast(intent)
            }
        }.start()
    }

    private fun downloadImage(imgURL: String, file: File): Boolean {
        var conn : HttpURLConnection? = null

        try {
            val url = URL(imgURL)

            conn = url.openConnection() as HttpURLConnection
            conn.requestMethod = "GET" // optional; default is GET

            if (conn.responseCode == HttpURLConnection.HTTP_OK) {
                outputToFile(conn, file)
            }

            return true
        } catch (e: Exception) {
            return false
        } finally {
            conn?.disconnect()
        }
    }

    private fun outputToFile(conn: HttpURLConnection, file: File) {
        val inp = conn.inputStream
        val outp = FileOutputStream(file)

        // for storing incoming raw bytes from input-stream
        val buf = ByteArray(4096)

        // read in first 4096 bytes
        var bytesRead = inp.read(buf)

        while (bytesRead != -1) {   // -1 means no more bytes to read
            // write to file the number of bytes read
            outp.write(buf, 0, bytesRead)

            // read from input-stream again
            bytesRead = inp.read(buf)
        }

        inp.close()
        outp.close()
    }

    public fun getFileExtension(str: String) : String {
        return str.substring(str.lastIndexOf("."))
    }

    private fun createDestFile(ext: String) : File {
        // using random string as filename to prevent filename clashes
        val filename = UUID.randomUUID().toString() + ext

        // storing under /files/PICTURES folder
        val dir = getExternalFilesDir(Environment.DIRECTORY_PICTURES)

        return File(dir, filename)
    }

    override fun onBind(intent: Intent): IBinder? {
        // TODO: Return the communication channel to the service.
        throw UnsupportedOperationException("Not yet implemented")
    }
}