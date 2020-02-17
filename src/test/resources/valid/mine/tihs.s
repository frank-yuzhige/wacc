.data

singleton_0:
    .word 6
    .ascii "%d\n\0\0"
singleton_1:
    .word 6
    .ascii "%s\n\0\0"
singleton_2:
    .word 43
    .ascii "DivideByZeroError: divide or modulo by zero\0"
msg_0:
    .word 81
    .ascii "OverflowError: the result is too small/large to store in a 4-byte signed-integer.\0"
.text

.global main
main:
    PUSH {lr}
    BLVS p_overflow_error
    SUB sp, sp, #8
    MOV r4, #5
    STR r4, [sp, #4]
    MOV r4, #3
    STR r4, [sp]
    LDR r4, [sp, #4]
    LDR r5, [sp]
    MOV r0, r4
    MOV r1, r4
    BL p_check_div_by_zero
    BL __aeabi_idiv
    MOV r1, r4
    LDR r0, =singleton_0
    BLVS p_overflow_error
    ADD r0, r0, #4
    BL printf
    MOV r0, #0
    BL fflush
    BLVS p_overflow_error
    ADD sp, sp, #8
    MOV r0, #0
    POP {pc}
    .ltorg
p_runtime_error:
    MOV r0, #-1
    BL exit
p_overflow_error:
    LDR r4, =msg_0
    MOV r1, r4
    BLVS p_overflow_error
    ADD r1, r1, #4
    LDR r0, =singleton_1
    BLVS p_overflow_error
    ADD r0, r0, #4
    BL printf
    MOV r0, #0
    BL fflush
    BL p_runtime_error
p_check_div_by_zero:
    PUSH {lr}
    CMP r1, #0
    LDREQ r0, =singleton_2
    BLEQ p_runtime_error
p_check_div_by_zero_seq_0:
    POP {pc}