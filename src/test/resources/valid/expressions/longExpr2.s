.data

singleton_0:
    .word 4
    .ascii "%s\n\0"
msg_0:
    .word 81
    .ascii "OverflowError: the result is too small/large to store in a 4-byte signed-integer.\0"
msg_1:
    .word 43
    .ascii "DivideByZeroError: divide or modulo by zero\0"
.text

.global main
main:
    PUSH {lr}
    SUB sp, sp, #4
    MOV r4, #2
    ADDS r4, r4, #3
    BLVS p_overflow_error
    ADDS r4, r4, #2
    BLVS p_overflow_error
    ADDS r4, r4, #1
    BLVS p_overflow_error
    ADDS r4, r4, #1
    BLVS p_overflow_error
    ADDS r4, r4, #1
    BLVS p_overflow_error
    MOV r5, #1
    ADDS r5, r5, #2
    BLVS p_overflow_error
    MOV r6, #3
    MOV r7, #4
    MOV r0, r7
    MOV r1, #6
    BL p_check_div_by_zero
    BL __aeabi_idiv
    MOV r7, r0
    SUBS r6, r6, r7
    BLVS p_overflow_error
    SMULL r5, r7, r5, r6
    CMP r7, r5, ASR #31
    BLNE p_overflow_error
    MOV r6, #2
    MOV r7, #18
    SUBS r7, r7, #17
    BLVS p_overflow_error
    SMULL r6, r8, r6, r7
    CMP r8, r6, ASR #31
    BLNE p_overflow_error
    MOV r7, #3
    MOV r8, #4
    SMULL r7, r8, r7, r8
    CMP r8, r7, ASR #31
    BLNE p_overflow_error
    MOV r0, r7
    MOV r1, #4
    BL p_check_div_by_zero
    BL __aeabi_idiv
    MOV r7, r0
    ADDS r7, r7, #6
    BLVS p_overflow_error
    ADDS r6, r6, r7
    BLVS p_overflow_error
    MOV r0, r5
    MOV r1, r6
    BL p_check_div_by_zero
    BL __aeabi_idiv
    MOV r5, r0
    SUBS r4, r4, r5
    BLVS p_overflow_error
    STR r4, [sp]
    LDR r4, [sp]
    MOV r0, r4
    BL exit
    ADD sp, sp, #4
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
    LDR r0, =singleton_0
    ADD r0, r0, #4
    BL printf
    MOV r0, #0
    BL fflush
    BL p_runtime_error
p_check_div_by_zero:
    PUSH {lr}
    CMP r1, #0
    BNE no_err_0
p_check_div_by_zero_seq_0:
    LDR r4, =msg_1
    MOV r1, r4
    ADD r1, r1, #4
    LDR r0, =singleton_0
    ADD r0, r0, #4
    BL printf
    MOV r0, #0
    BL fflush
    BLEQ p_runtime_error
no_err_0:
    POP {pc}