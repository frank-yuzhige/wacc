.data

singleton_0:
    .word 4
    .ascii "%c\n\0"
msg_0:
    .word 5
    .ascii "hello\0"
.text

.global main
main:
    PUSH {lr}
    SUB sp, sp, #26
    MOV r4, #1
    STR r4, [sp, #4]
    MOV r4, #1
    STR r4, [sp, #8]
    LDR r4, =msg_0
    STR r4, [sp, #22]
    LDR r4, [sp, #4]
    STR r4, [sp]
    MOV r0, #8
    BL malloc
    MOV r4, r0
    LDR r5, [sp, #4]
    MOV r0, #4
    BL malloc
    STR r5, [r0]
    STR r0, [r4]
    LDRSB r5, [sp, #8]
    MOV r0, #1
    BL malloc
    STRB r5, [r0]
    STR r0, [r4, #4]
    STR r4, [sp, #18]
    MOV r0, #8
    BL malloc
    MOV r4, r0
    LDR r5, [sp, #18]
    MOV r0, #4
    BL malloc
    STR r5, [r0]
    STR r0, [r4]
    LDR r5, [sp, #22]
    MOV r0, #4
    BL malloc
    STR r5, [r0]
    STR r0, [r4, #4]
    STR r4, [sp, #14]
    MOV r0, #8
    BL malloc
    MOV r4, r0
    LDR r5, [sp, #14]
    STR r5, [r4, #4]
    MOV r5, #1
    STR r5, [r4]
    STR r4, [sp, #10]
    LDR r4, [sp, #4]
    STR r4, [sp, #-4]!
    LDR r4, [sp, #4]
    STR r4, [sp, #-4]!
    BL f_f_0
    ADD sp, sp, #8
    MOV r4, r0
    STR r4, [sp, #9]
    LDRSB r4, [sp, #9]
    MOV r1, r4
    LDR r0, =singleton_0
    ADD r0, r0, #4
    BL printf
    MOV r0, #0
    BL fflush
    ADD sp, sp, #26
    MOV r0, #0
    POP {pc}
    .ltorg
f_f_0:
    PUSH {lr}
    SUB sp, sp, #1
    LDR r4, [sp, #5]
    STR r4, [sp]
    LDRSB r4, [sp]
    ADD sp, sp, #1
    MOV r0, r4
    POP {pc}
    .ltorg
