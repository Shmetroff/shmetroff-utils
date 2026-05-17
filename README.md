# Shmetroff Utils
My own java lib with helper tools and utils

Structure:

```text
ru.shmetroff.com
├── http/
│   └── Cookies.java
│       └── + [s] print(Cookie): void             # prints all Cookie attributes in a human-friendly format 
│
└── tools/
    ├── Addr.java
    │   ├── + [s] get(Object): int                # returns hash code of the Object (addres in RAM)
    │   └── + [s] hex(Object): String             # returns hash code of the Object (addres in RAM) in a 0x hex format
    │
    ├── ByteArray.java
    │   ├── + [s] printHex(byte[], String): void  # prints array of byte in a beautiful hex table with offsets and chars 
    │   └── + [s] printHex(byte[]):         void  # like above but with defaultCharset
    │
    ├── Order.java                                # enum for indicate directions: DIRECT, REVERSE
    │
    ├── RndStr.java
    │   ├── + [s] gen(int):   String              # returns random String with specified legnth (parameter)
    │   ├── + [s] gens(int):  String              # like above but uses Streams
    │   ├── + [s] gensp(int): String              # like above but uses Parallel Streams
    │
    ├── StopWatch.java
    │   ├── + start(String, boolean): void        # starts StopWatch, set name & debug flag (prints header with name if debug is true)
    │   ├── + start(String):          void        # like above but debug always is false (never prints header)
    │   └── + stop():                 void        # stops StopWatch, print time in MS with name
    │
    └── Str.java
        └── + [s] repeat(String, int): String     # repeats the String (parameter) the int times (parameter)
```
