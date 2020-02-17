.data

singleton_0:
    .word 4
    .ascii "%d\n\0"
singleton_1:
    .word 4
    .ascii "%s\n\0"
msg_0:
    .word 81
    .ascii "OverflowError: the result is too small/large to store in a 4-byte signed-integer.\0"
.text

.global main
main:
    PUSH {lr}
    MOV r4, #1
    SUBS r4, r4, #2
    BLVS p_overflow_error
    MOV r1, r4
    LDR r0, =singleton_0
    ADD r0, r0, #4
    BL printf
    MOV r0, #0
    BL fflush
    MOV r0, #0
    POP {pc}
    .ltorg
p_runtime_error:
    MOV r0, #-1
    BL exit
p_overflow_error:
    LDR r4, =msg_0
    MOV r1, r4
    ADD r1, r1, #4
    LDR r0, =singleton_1
    ADD r0, r0, #4
    BL printf
    MOV r0, #0
    BL fflush
    BL p_runtime_error
