arm-linux-gnueabi-gcc -o ticTacToe -mcpu=arm1176jzf-s -mtune=arm1176jzf-s src/test/resources/valid/mine/gen.s
qemu-arm -L /usr/arm-linux-gnueabi/ ticTacToe
echo "\nCleaning up...\n"
rm -rf ticTacToe ticTacToe.s