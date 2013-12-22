Android Callback
================

This is a quick-and-dirty project that reads Android source files and
searches methods whose comments include keyword ``callback.''

First, change variable _android.dir_ in build.xml accordingly.
Then, run the following command:

    $ ant | sed -n '/\[javadoc\] android.*/p' > callback.txt

