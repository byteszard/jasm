<div align="center">

  <h1><code>JaSM</code></h1>

  <strong>
  A java example project using <a href="https://github.com/bytesboy/wrapped-sm-for-java.git">libwsm4j.dylib</a> and JNI to call 
  <a href="https://github.com/bytesboy/Yet-Another-Rust-Implementation-Of-SM-Algorithms.git">
  Yarism</a> function.
  </strong>

</div>

## 🚴 Usage

1. Define Java class and method. For example: `HelloWorld.java`
2. Execute `javac -h . HelloWorld.java` command to compile `*.h` file.
3. Get the name and type signature from the `.h` file.
4. Define Rust method with the name and type signature in <a href="https://github.com/bytesboy/wrapped-sm-for-java">wrapped-sm-for-java</a>
5. Then compile project to `libwsm4j.dylib` or `libwsm4j.so` with command `cargo build --release`
6. Get the dylib file and put on the server or java
7. `System.load(dylib_path_with_file_suffix)`  or `System.loadLibrary(dylit_name_without_suffix)`