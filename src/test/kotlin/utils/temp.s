.data


.text

.global main
main:
    PUSH {lr}
    SUB sp, sp, #36
    BLVS p_overflow_error
    MOV r4, #1
    ADD r4, r4, #2
    BLVS p_overflow_error
    STR r4, [sp, #32]
    MOV r4, #3
    ADD r4, r4, #4
    BLVS p_overflow_error
    STR r4, [sp, #28]
    MOV r4, #5
    ADD r4, r4, #6
    BLVS p_overflow_error
    STR r4, [sp, #24]
    MOV r4, #7
    ADD r4, r4, #8
    BLVS p_overflow_error
    STR r4, [sp, #20]
    MOV r4, #9
    ADD r4, r4, #10
    BLVS p_overflow_error
    STR r4, [sp, #16]
    MOV r4, #11
    ADD r4, r4, #12
    BLVS p_overflow_error
    STR r4, [sp, #12]
    MOV r4, #13
    ADD r4, r4, #14
    BLVS p_overflow_error
    STR r4, [sp, #8]
    MOV r4, #15
    ADD r4, r4, #16
    BLVS p_overflow_error
    STR r4, [sp, #4]
    MOV r4, #17
    STR r4, [sp]
    LDR r4, [sp, #32]
    LDR r5, [sp, #28]
    ADD r4, r4, r5
    BLVS p_overflow_error
    LDR r6, [sp, #24]
    ADD r4, r4, r6
    BLVS p_overflow_error
    LDR r7, [sp, #20]
    ADD r4, r4, r7
    BLVS p_overflow_error
    LDR r8, [sp, #16]
    ADD r4, r4, r8
    BLVS p_overflow_error
    LDR r9, [sp, #12]
    ADD r4, r4, r9
    BLVS p_overflow_error
    LDR r10, [sp, #8]
    ADD r4, r4, r10
    BLVS p_overflow_error
    LDR r11, [sp, #4]
    ADD r4, r4, r11
    BLVS p_overflow_error
    LDR r12, [sp]
    ADD r4, r4, r12
    BLVS p_overflow_error
    MOV r0, r4
    BL exit
    ADD sp, sp, #36
    BLVS p_overflow_error
    MOV r0, #0
    POP {pc}
    .ltorg
