package app.gyrolet.mpvrx.ui.browser.cards

import app.gyrolet.mpvrx.ui.icons.AppIcon
import app.gyrolet.mpvrx.ui.icons.Icons

fun getSmartIconForFolder(folderName: String): AppIcon? {
    val name = folderName.lowercase().trim()

    return when {
        // أفلام
        name.contains("film") || name.contains("movie") || name.contains("فيلم") ||
            name.contains("افلام") || name.contains("أفلام") -> AppIcon(Icons.RoundedFilled.Movie)

        // مسلسلات
        name.contains("series") || name.contains("tv") || name.contains("مسلسل") ||
            name.contains("موسم") || name.contains("season") -> AppIcon(Icons.RoundedFilled.Tv)

        // قرآن
        name.contains("قرآن") || name.contains("قران") || name.contains("quran") ||
            name.contains("surah") || name.contains("سورة") -> AppIcon(Icons.RoundedFilled.MenuBook)

        // موسيقى
        name.contains("music") || name.contains("song") || name.contains("صوتيات") ||
            name.contains("أغاني") || name.contains("اغاني") || name.contains("أناشيد") -> AppIcon(Icons.RoundedFilled.MusicNote)

        // صور
        name.contains("photo") || name.contains("image") || name.contains("صور") ||
            name.contains("كاميرا") || name.contains("camera") -> AppIcon(Icons.RoundedFilled.Image)

        // تحميلات
        name.contains("download") || name.contains("تحميل") -> AppIcon(Icons.RoundedFilled.Download)

        // أرشيف
        name.contains(".zip") || name.contains("archive") || name.contains("أرشيف") -> AppIcon(Icons.RoundedFilled.FolderZip)

        // تسجيل الشاشة
        name.contains("screen") || name.contains("recording") || name.contains("تسجيل") -> AppIcon(Icons.RoundedFilled.Videocam)

        // شبكة
        name.contains("smb") || name.contains("ftp") || name.contains("network") || name.contains("webdav") -> AppIcon(Icons.RoundedFilled.Cloud)

        else -> null
    }
}
