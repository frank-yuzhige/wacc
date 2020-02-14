.data

msg_0:
    .word 4
    .ascii "true\0"
msg_1:
    .word 5
    .ascii "false\0"
msg_2:
    .word 6
    .ascii "%s\n\0\0"
.text

.global main
main:
    PUSH {lr}
    SUB sp, sp, #12
    MOV r4, #1
    STR r4, [sp]
    MOV r4, #0
    STR r4, [sp, #8]
    LDR r4, [sp]
    LDR r5, [sp, #8]
    AND r4, r4, r5
    STR r4, [sp, #4]
    LDR r4, [sp, #4]
    CMP r4, #0
    LDRNE r1, =msg_0
    LDREQ r1, =msg_1
    ADD r1, r1, #4
    LDR r0, =msg_2
    ADD r0, r0, #4
    BL printf
    MOV r0, #0
    BL fflush
    ADD sp, sp, #12
    MOV r0, #0
    POP {pc}
    .ltorg
