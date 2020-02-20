make
./compile src/test/resources/valid/advanced/ticTacToe.wacc
arm-linux-gnueabi-gcc -o ticTacToe -mcpu=arm1176jzf-s -mtune=arm1176jzf-s ticTacToe.s
qemu-arm -L /usr/arm-linux-gnueabi/ ticTacToe
echo "\nCleaning up...\n"
rm -rf ticTacToe ticTacToe.s