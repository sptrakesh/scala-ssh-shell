scala-ssh-shell
===============

Backdoor that gives you a scala shell over ssh on your jvm

NOTE: The shell is not sandboxed, anyone access the shell can touch
anything in the jvm and do anything the jvm can do including modifying
and deleting files, etc. Use at your own risk. No guarantees are made
regarding this being secure.

Usage
-----

Embed this in your code by running the following:

    val sshd = new ScalaSshShell(port=4444, name="test", user="user",
                                 passwd="fluke",
                                 keysResourcePath=Some("/test.ssh.keys"))
    sshd.bind("pi", 3.1415926)
    sshd.bind("nums", Vector(1,2,3,4,5))
    sshd.start()

Most of that should be self explanatory. The 'name' is the name that
will be used for the parent thread, as well as the name that will
appear in the prompt that the user sees. A good idea is to name it
after the service the jvm is providing so if the user sshes into the
wrong jvm they'll immediately see a visual indication that they aren't
where they expected to be.

To shut down ssh service, call:

    sshd.stop()

To generate your keys run ScalaSshShell.generateKeys(), which can be
done from a scala shell:

    scala> peak6.util.ScalaSshShell.generateKeys("src/main/resources/test.ssh.keys")

To run the included example, run the following:

    $ ant standalone
    $ java -jar deploy/sshshell-0.0.1.jar

Now you can ssh in from a separate window, using "fluke" for the
password:

    $ ssh -l user -p 4444 localhost
    user@localhost's password:
    Connected to test, starting repl...
    Welcome to Scala version 2.9.1.r0-b20110831114755 (Java HotSpot(TM) 64-Bit Server VM, Java 1.7.0).
    Type in expressions to have them evaluated.
    Type :help for more information.
    test> nums.sum
    res0: Int = 15
    test> pi/2
    res1: Double = 1.5707963
    test> println("Hello World!")
    Hello World!
