package utils

import java.io.OutputStream

class NullOutputStream: OutputStream() {
    override fun write(p0: Int) {
        // Does absolutely nothing!
    }
}