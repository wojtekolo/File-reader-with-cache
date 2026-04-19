# File reader utilizing Weak Reference
## Wrocław University of Science and Technology - Laboratory Assignment. Project developed as part of Advanced Techniques in Java course. Focused on Weak References
A Java-based utility for file reading. The system utilizes `WeakReference` to implement cache mechanism allowing the Garbage Collector to reclaim memory. This prevents 
`OutOfMemoryError` when handling large files.
\
Implemented a `Strategy Pattern` allowing to proccess different file formats without modyfing the core engine.
