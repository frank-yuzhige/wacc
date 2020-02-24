.data

singleton_0:
    .word 2
    .ascii "%s\0"
singleton_1:
    .word 4
    .ascii "%d\n\0"
singleton_2:
    .word 4
    .ascii "%s\n\0"
msg_0:
    .word 12
    .ascii "min value = \0"
msg_1:
    .word 81
    .ascii "OverflowError: the result is too small/large to store in a 4-byte signed-integer.\0"
.text

.global main
main:
    PUSH {lr}
    SUB sp, sp, #12
    MOV r4, #0
    STR r4, [sp, #4]
    MOV r4, #10
    STR r4, [sp, #8]
    MOV r4, #17
    STR r4, [sp]
loop_check_0:
    LDR r4, [sp]
    CMP r4, #0
    MOVGT r4, #1
    MOVLE r4, #0
    LDR r5, [sp, #8]
    CMP r5, #0
    MOVGT r5, #1
    MOVLE r5, #0
    AND r4, r4, r5
    CMP r4, #0
    BEQ loop_end_0
loop_body_0:
    LDR r4, [sp, #8]
    SUB r4, r4, #1
    BLVS p_overflow_error
    STR r4, [sp, #8]
    LDR r4, [sp]
    SUB r4, r4, #1
    BLVS p_overflow_error
    STR r4, [sp]
    LDR r4, [sp, #4]
    ADD r4, r4, #1
    BLVS p_overflow_error
    STR r4, [sp, #4]
    B loop_check_0
loop_end_0:
    LDR r4, =msg_0
    MOV r1, r4
    ADD r1, r1, #4
    LDR r0, =singleton_0
    ADD r0, r0, #4
    BL printf
    MOV r0, #0
    BL fflush
    LDR r4, [sp, #4]
    MOV r1, r4
    LDR r0, =singleton_1
    ADD r0, r0, #4
    BL printf
    MOV r0, #0
    BL fflush
    ADD sp, sp, #12
    MOV r0, #0
    POP {pc}
    .ltorg
p_runtime_error:
    MOV r0, #-1
    BL exit
p_overflow_error:
    LDR r4, =msg_1
    MOV r1, r4
    ADD r1, r1, #4
    LDR r0, =singleton_2
    ADD r0, r0, #4
    BL printf
    MOV r0, #0
    BL fflush
    BL p_runtime_error