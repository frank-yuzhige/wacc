.data

msg_0:
    .word 6
    .ascii "%d\n\0\0"
.text

.global main
main:
    PUSH {lr}
    SUB sp, sp, #4
    MOV r4, #13
    STR r4, [sp]
    LDR r5, [sp]
    CMP r5, #13
    MOVEQ r5, #1
    MOVNE r5, #0
    CMP r5, #0
    BEQ if_else_0
if_then_0:
    MOV r6, #1
    STR r6, [sp]
    ADD sp, sp, #4
    B if_end_0
if_else_0:
    MOV r7, #0
    STR r7, [sp, #-4]
    ADD sp, sp, #4
    B if_end_0
if_end_0:
    LDR r8, [sp, #-8]
    MOV r1, r8
    LDR r0, =msg_0
    ADD r0, r0, #4
    BL printf
    MOV r0, #0
    BL fflush
    SUB sp, sp, #4
    MOV r0, #0
    POP {pc}
    .ltorg
