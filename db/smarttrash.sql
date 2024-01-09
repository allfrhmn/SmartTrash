-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: localhost:3306
-- Waktu pembuatan: 09 Jan 2024 pada 01.30
-- Versi server: 8.0.30
-- Versi PHP: 8.1.10

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `smarttrash`
--

-- --------------------------------------------------------

--
-- Struktur dari tabel `jenis`
--

CREATE TABLE `jenis` (
  `id` int NOT NULL,
  `nama` varchar(255) NOT NULL,
  `id_kategori` int NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data untuk tabel `jenis`
--

INSERT INTO `jenis` (`id`, `nama`, `id_kategori`) VALUES
(2, 'Blender', 2),
(3, 'Router', 4),
(4, 'Printer', 7),
(5, 'Monitor Jantung', 6),
(6, 'Motherboard', 3);

-- --------------------------------------------------------

--
-- Struktur dari tabel `kategori`
--

CREATE TABLE `kategori` (
  `id` int NOT NULL,
  `nama` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data untuk tabel `kategori`
--

INSERT INTO `kategori` (`id`, `nama`) VALUES
(2, 'Peralatan Elektronik'),
(3, 'Perangkat Komputer'),
(4, 'Perangkat Jaringan'),
(6, 'Peralatan Medis'),
(7, 'Peralatan Kantor');

-- --------------------------------------------------------

--
-- Struktur dari tabel `masyarakat`
--

CREATE TABLE `masyarakat` (
  `id` int NOT NULL,
  `nama` varchar(255) NOT NULL,
  `alamat` text NOT NULL,
  `nomor_telepon` varchar(15) NOT NULL,
  `email` varchar(255) NOT NULL,
  `status_pendaftaran` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data untuk tabel `masyarakat`
--

INSERT INTO `masyarakat` (`id`, `nama`, `alamat`, `nomor_telepon`, `email`, `status_pendaftaran`) VALUES
(1, 'Allfiandi', 'Cimahi', '1234567890', 'allfiandi@gmail.com', 'Sukses'),
(2, 'Emilia', 'Sukabumi', '2345678901', 'emilia@gmail.com', 'Sukses'),
(3, 'Acep', 'Subang', '3456789012', 'acep@gmail.com', 'Sukses'),
(4, 'Deni', 'Subang', '4567890123', 'deni@gmail.com', 'Sukses'),
(5, 'Salma', 'Cimahi', '5678901234', 'salma@gmail.com', 'Sukses');

-- --------------------------------------------------------

--
-- Struktur dari tabel `penjemputan`
--

CREATE TABLE `penjemputan` (
  `id` int NOT NULL,
  `tanggal_penjemputan` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `status_penjemputan` varchar(255) NOT NULL,
  `keputusan_konfirmasi` varchar(255) NOT NULL,
  `tanggal_konfirmasi` varchar(100) NOT NULL,
  `tanggal_riwayat` varchar(100) NOT NULL,
  `id_masyarakat` int NOT NULL,
  `id_petugas` int NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data untuk tabel `penjemputan`
--

INSERT INTO `penjemputan` (`id`, `tanggal_penjemputan`, `status_penjemputan`, `keputusan_konfirmasi`, `tanggal_konfirmasi`, `tanggal_riwayat`, `id_masyarakat`, `id_petugas`) VALUES
(1, '12 September 2023', 'Sukses', 'Sudah Verifikasi', '13 September 2023', '14 September 2023', 1, 3),
(2, '10 Oktober 2023', 'Sukses', 'Sudah Verifikasi', '11 Oktober 2023', '12 Oktober 2023', 2, 5),
(3, '31 Otkober 2023', 'Sukses', 'Sudah Verifikasi', '1 November 2023', '2 November 2023', 3, 4),
(4, '11 November 2023', 'Sukses', 'Sudah Verifikasi', '12 November 2023', '13 November 2023', 4, 1),
(5, '24 November 2023', 'Sukses', 'Sudah Verifikasi', '25 November 2023', '26 November 2023', 5, 2);

-- --------------------------------------------------------

--
-- Struktur dari tabel `petugas`
--

CREATE TABLE `petugas` (
  `id` int NOT NULL,
  `nama` varchar(255) NOT NULL,
  `alamat` text NOT NULL,
  `nomor_telepon` varchar(15) NOT NULL,
  `jabatan` varchar(255) NOT NULL,
  `status_pendaftaran` varchar(100) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data untuk tabel `petugas`
--

INSERT INTO `petugas` (`id`, `nama`, `alamat`, `nomor_telepon`, `jabatan`, `status_pendaftaran`) VALUES
(1, 'Rahman', 'Cipularang', '6789012345', 'Staff', 'Sukses'),
(2, 'Paradila', 'Sukaluyu', '7890123456', 'Admin', 'Sukses'),
(3, 'Imam', 'Padalarang', '8901234567', 'Staff', 'Sukses'),
(4, 'Pajrianingrat', 'Mojokerto', '9012345678', 'Admin', 'Sukses'),
(5, 'Salsabila', 'Bandung Raya', '0987654321', 'Staff', 'Sukses');

-- --------------------------------------------------------

--
-- Struktur dari tabel `poin`
--

CREATE TABLE `poin` (
  `id` int NOT NULL,
  `jumlah_poin` int NOT NULL,
  `id_kategori` int NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data untuk tabel `poin`
--

INSERT INTO `poin` (`id`, `jumlah_poin`, `id_kategori`) VALUES
(1, 150, 6),
(2, 125, 4),
(3, 50, 3),
(4, 100, 2),
(5, 25, 7);

--
-- Indexes for dumped tables
--

--
-- Indeks untuk tabel `jenis`
--
ALTER TABLE `jenis`
  ADD PRIMARY KEY (`id`),
  ADD KEY `id_kategori` (`id_kategori`);

--
-- Indeks untuk tabel `kategori`
--
ALTER TABLE `kategori`
  ADD PRIMARY KEY (`id`);

--
-- Indeks untuk tabel `masyarakat`
--
ALTER TABLE `masyarakat`
  ADD PRIMARY KEY (`id`);

--
-- Indeks untuk tabel `penjemputan`
--
ALTER TABLE `penjemputan`
  ADD PRIMARY KEY (`id`),
  ADD KEY `id_masyarakat` (`id_masyarakat`),
  ADD KEY `id_petugas` (`id_petugas`);

--
-- Indeks untuk tabel `petugas`
--
ALTER TABLE `petugas`
  ADD PRIMARY KEY (`id`);

--
-- Indeks untuk tabel `poin`
--
ALTER TABLE `poin`
  ADD PRIMARY KEY (`id`),
  ADD KEY `id_kategori` (`id_kategori`);

--
-- AUTO_INCREMENT untuk tabel yang dibuang
--

--
-- AUTO_INCREMENT untuk tabel `jenis`
--
ALTER TABLE `jenis`
  MODIFY `id` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT untuk tabel `kategori`
--
ALTER TABLE `kategori`
  MODIFY `id` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT untuk tabel `masyarakat`
--
ALTER TABLE `masyarakat`
  MODIFY `id` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT untuk tabel `penjemputan`
--
ALTER TABLE `penjemputan`
  MODIFY `id` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT untuk tabel `petugas`
--
ALTER TABLE `petugas`
  MODIFY `id` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT untuk tabel `poin`
--
ALTER TABLE `poin`
  MODIFY `id` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- Ketidakleluasaan untuk tabel pelimpahan (Dumped Tables)
--

--
-- Ketidakleluasaan untuk tabel `jenis`
--
ALTER TABLE `jenis`
  ADD CONSTRAINT `jenis_ibfk_1` FOREIGN KEY (`id_kategori`) REFERENCES `kategori` (`id`);

--
-- Ketidakleluasaan untuk tabel `penjemputan`
--
ALTER TABLE `penjemputan`
  ADD CONSTRAINT `penjemputan_ibfk_1` FOREIGN KEY (`id_masyarakat`) REFERENCES `masyarakat` (`id`),
  ADD CONSTRAINT `penjemputan_ibfk_2` FOREIGN KEY (`id_petugas`) REFERENCES `petugas` (`id`);

--
-- Ketidakleluasaan untuk tabel `poin`
--
ALTER TABLE `poin`
  ADD CONSTRAINT `poin_ibfk_1` FOREIGN KEY (`id_kategori`) REFERENCES `kategori` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
