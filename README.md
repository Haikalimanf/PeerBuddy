# YourPeerBuddy - Aplikasi Kesehatan Mental

YourPeerBuddy adalah aplikasi kesehatan mental yang dirancang untuk memberikan dukungan, sumber daya, dan fitur interaktif untuk mempromosikan kesejahteraan mental. Aplikasi ini mengikuti pola arsitektur MVVM (Model-View-ViewModel), memastikan kode yang bersih dan mudah dipelihara. Proyek ini dibangun dengan praktik terbaik, memisahkan tanggung jawab aplikasi ke dalam lapisan-lapisan yang jelas untuk memudahkan pengujian, skalabilitas, dan pemeliharaan.

## Arsitektur

YourPeerBuddy mengikuti pola arsitektur **MVVM (Model-View-ViewModel)**, yang mempromosikan pemisahan yang jelas antara UI dan logika dasar aplikasi. Berikut adalah penjelasan tentang struktur proyek:

### Struktur Folder

### 1. **data** 
Folder `data` menangani semua logika terkait data dalam aplikasi. Ini termasuk panggilan jaringan, penyimpanan data, dan manajemen sumber data eksternal (seperti API atau database). Lapisan data terpisah dari UI dan logika bisnis, menyediakan antarmuka yang bersih untuk mengambil dan menyimpan data tanpa melibatkan logika presentasi.

- **Tanggung Jawab**:
  - Manajemen sumber data (lokal dan jarak jauh).
  - Repositori untuk berinteraksi dengan sumber data.
  - Panggilan jaringan, interaksi API, dan transformasi data.

### 2. **model**
Folder `model` berisi semua model domain aplikasi. Ini adalah objek yang mewakili data dalam aplikasi dan dapat dibagikan antar lapisan yang berbeda. Model ini adalah wadah data sederhana yang menyimpan data mentah, yang dapat ditransformasikan atau diproses di ViewModel.

- **Tanggung Jawab**:
  - Mendefinisikan struktur data (misalnya, User, Post, MentalHealthTips).
  - DTO (Data Transfer Objects) untuk data API.
  - Model domain untuk logika bisnis inti.

### 3. **ui**
Folder `ui` adalah tempat elemen antarmuka pengguna berada. Ini berisi sumber daya tata letak, aktivitas, fragmen, dan komponen UI lainnya. Lapisan UI hanya bertanggung jawab untuk menampilkan data dan mendelegasikan interaksi pengguna ke ViewModel.

- **Tanggung Jawab**:
  - File tata letak (XML).
  - Komponen UI (Aktivitas, Fragmen, dll.).
  - Menangani interaksi pengguna dan mengirimkan data ke ViewModel.

### 4. **viewmodel**
Folder `viewmodel` berisi kelas-kelas ViewModel. Kelas-kelas ini bertanggung jawab untuk logika presentasi, mengambil data dari lapisan model, dan mempersiapkannya untuk ditampilkan di lapisan UI. ViewModel menyadari logika bisnis dan dapat memformat data sesuai kebutuhan untuk UI.

- **Tanggung Jawab**:
  - Mengekspos live data ke UI (misalnya, LiveData atau StateFlow).
  - Menangani tindakan pengguna dan mengirimkannya ke lapisan model untuk diproses.
  - Mengelola logika terkait UI dan transformasi data.

### 5. **utils**
Folder `utils` berisi fungsi utilitas, kelas pembantu, dan fungsi ekstensi yang digunakan di seluruh aplikasi. Utilitas ini membantu menjaga kode tetap DRY (Don’t Repeat Yourself) dan menyediakan fitur-fitur yang sering digunakan seperti validasi, pemformatan tanggal/waktu, atau algoritma umum.

- **Tanggung Jawab**:
  - Fungsi pembantu yang dapat digunakan ulang.
  - Fungsi ekstensi untuk tugas-tugas umum.
  - Utilitas untuk menyederhanakan keterbacaan dan pemeliharaan kode.


## Cara Menjalankan Aplikasi

Untuk menjalankan aplikasi YourPeerBuddy, ikuti langkah-langkah di bawah ini:

1. Kloning repositori:
    ```bash
    git clone https://github.com/Haikalimanf/PeerBuddy.git
    ```

2. Buka proyek di Android Studio.

3. Sinkronkan file Gradle untuk memastikan semua dependensi diunduh dengan benar.

4. Sambungkan perangkat Android atau gunakan emulator.

5. Jalankan aplikasinya!
