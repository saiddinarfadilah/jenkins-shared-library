import com.example.SampleHelper3

def call() {
    // Menggunakan helper untuk mencetak konfigurasi
    SampleHelper3.printConfig(this)

    try {
        // Membangun proyek
        SampleHelper3.buildProject(this)

        // Menjalankan pengujian
        SampleHelper3.runTests(this)

        // Notifikasi sukses
        SampleHelper3.notify('success', this)
    } catch (Exception e) {
        // Notifikasi gagal
        SampleHelper3.notify('failure', this)
        throw e
    }
}
