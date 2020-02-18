.data

singleton_0:
    .word 2
    .ascii "%s\0"
singleton_1:
    .word 2
    .ascii "%d\0"
singleton_4:
    .word 4
    .ascii "%s\n\0"
singleton_12:
    .word 2
    .ascii "%c\0"
msg_0:
    .word 47
    .ascii "Please enter the number of integers to insert: \0"
msg_1:
    .word 10
    .ascii "There are \0"
msg_2:
    .word 10
    .ascii " integers.\0"
msg_3:
    .word 36
    .ascii "Please enter the number at position \0"
msg_4:
    .word 3
    .ascii " : \0"
msg_5:
    .word 29
    .ascii "Here are the numbers sorted: \0"
msg_6:
    .word 0
    .ascii "\0"
msg_7:
    .word 81
    .ascii "OverflowError: the result is too small/large to store in a 4-byte signed-integer.\0"
msg_8:
    .word 48
    .ascii "NullReferenceError: dereference a null reference\0"
.text

.global main
main:
    PUSH {lr}
    SUB sp, sp, #12
    MOV r4, #0
    STR r4, [sp]
    LDR r4, =msg_0
    MOV r1, r4
    ADD r1, r1, #4
    LDR r0, =singleton_0
    ADD r0, r0, #4
    BL printf
    MOV r0, #0
    BL fflush
    ADD r1, sp, #0
    LDR r0, =singleton_1
    ADD r0, r0, #4
    BL scanf
    LDR r4, =msg_1
    MOV r1, r4
    ADD r1, r1, #4
    LDR r0, =singleton_0
    ADD r0, r0, #4
    BL printf
    MOV r0, #0
    BL fflush
    LDR r4, [sp]
    MOV r1, r4
    LDR r0, =singleton_1
    ADD r0, r0, #4
    BL printf
    MOV r0, #0
    BL fflush
    LDR r4, =msg_2
    MOV r1, r4
    ADD r1, r1, #4
    LDR r0, =singleton_4
    ADD r0, r0, #4
    BL printf
    MOV r0, #0
    BL fflush
    MOV r4, #0
    STR r4, [sp, #4]
    MOV r4, #0
    STR r4, [sp, #8]
loop_check_0:
    LDR r4, [sp, #4]
    LDR r5, [sp]
    CMP r4, r5
    MOVLT r4, #1
    MOVGE r4, #0
    CMP r4, #0
    BEQ loop_end_0
loop_body_0:
    SUB sp, sp, #4
    MOV r4, #0
    STR r4, [sp]
    LDR r4, =msg_3
    MOV r1, r4
    ADD r1, r1, #4
    LDR r0, =singleton_0
    ADD r0, r0, #4
    BL printf
    MOV r0, #0
    BL fflush
    LDR r4, [sp, #8]
    ADDS r4, r4, #1
    BLVS p_overflow_error
    MOV r1, r4
    LDR r0, =singleton_1
    ADD r0, r0, #4
    BL printf
    MOV r0, #0
    BL fflush
    LDR r4, =msg_4
    MOV r1, r4
    ADD r1, r1, #4
    LDR r0, =singleton_0
    ADD r0, r0, #4
    BL printf
    MOV r0, #0
    BL fflush
    ADD r1, sp, #0
    LDR r0, =singleton_1
    ADD r0, r0, #4
    BL scanf
    LDR r4, [sp, #12]
    STR r4, [sp, #-4]!
    LDR r4, [sp]
    STR r4, [sp, #-4]!
    BL insert_0
    ADD sp, sp, #8
    STR r0, [sp, #12]
    LDR r0, [sp, #8]
    ADDS r0, r0, #1
    BLVS p_overflow_error
    STR r0, [sp, #8]
    ADD sp, sp, #4
    B loop_check_0
loop_end_0:
    LDR r0, =msg_5
    MOV r1, r0
    ADD r1, r1, #4
    LDR r0, =singleton_0
    ADD r0, r0, #4
    BL printf
    MOV r0, #0
    BL fflush
    LDR r0, [sp, #8]
    STR r0, [sp, #-4]!
    BL printTree_0
    ADD sp, sp, #4
    STR r0, [sp, #4]
    LDR r0, =msg_6
    MOV r1, r0
    ADD r1, r1, #4
    LDR r0, =singleton_4
    ADD r0, r0, #4
    BL printf
    MOV r0, #0
    BL fflush
    ADD sp, sp, #12
    MOV r0, #0
    POP {pc}
    .ltorg
createNewNode_0:
    PUSH {lr}
    SUB sp, sp, #20
    MOV r5, #8
    MOV r0, r5
    BL malloc
    MOV r4, r0
    MOV r5, #4
    MOV r0, r5
    BL malloc
    LDR r5, [sp, #8]
    STR r5, [r0]
    STR r0, [r4]
    MOV r5, #4
    MOV r0, r5
    BL malloc
    LDR r5, [sp, #4]
    STR r5, [r0]
    STR r0, [r4, #4]
    STR r4, [sp, #16]
    MOV r6, #8
    MOV r0, r6
    BL malloc
    MOV r4, r0
    MOV r6, #4
    MOV r0, r6
    BL malloc
    LDR r6, [sp]
    STR r6, [r0]
    STR r0, [r4]
    MOV r6, #4
    MOV r0, r6
    BL malloc
    LDR r6, [sp, #16]
    STR r6, [r0]
    STR r0, [r4, #4]
    STR r4, [sp, #12]
    LDR r4, [sp, #12]
    ADD sp, sp, #20
    MOV r0, r4
    POP {pc}
    .ltorg
insert_0:
    PUSH {lr}
    SUB sp, sp, #8
    LDR r4, [sp, #4]
    CMP r4, #0
    MOVEQ r4, #1
    MOVNE r4, #0
    CMP r4, #0
    BEQ if_else_0
if_then_0:
    LDR r4, [sp]
    STR r4, [sp, #-4]!
    MOV r4, #0
    STR r4, [sp, #-4]!
    MOV r4, #0
    STR r4, [sp, #-4]!
    BL createNewNode_0
    ADD sp, sp, #12
    STR r0, [sp, #4]
    B if_end_0
if_else_0:
    SUB sp, sp, #12
    LDR r0, [sp, #16]
    BL p_check_null_ptr
    LDR r0, [r0, #4]
    LDR r0, [r0]
    STR r0, [sp, #8]
    LDR r0, [sp, #16]
    BL p_check_null_ptr
    LDR r0, [r0]
    LDR r0, [r0]
    STR r0, [sp]
    MOV r0, #0
    STR r0, [sp, #4]
    LDR r0, [sp, #12]
    LDR r4, [sp]
    CMP r0, r4
    MOVLT r0, #1
    MOVGE r0, #0
    CMP r0, #0
    BEQ if_else_1
if_then_1:
    LDR r0, [sp, #8]
    BL p_check_null_ptr
    LDR r0, [r0]
    LDR r0, [r0]
    STR r0, [sp, #4]
    LDR r0, [sp, #4]
    STR r0, [sp, #-4]!
    LDR r0, [sp, #12]
    STR r0, [sp, #-4]!
    BL insert_0
    ADD sp, sp, #8
    LDR r0, [sp, #8]
    BL p_check_null_ptr
    LDR r0, [r0]
    STR r0, [r0]
    B if_end_1
if_else_1:
    LDR r0, [sp, #8]
    BL p_check_null_ptr
    LDR r0, [r0, #4]
    LDR r0, [r0]
    STR r0, [sp, #4]
    LDR r0, [sp, #4]
    STR r0, [sp, #-4]!
    LDR r0, [sp, #12]
    STR r0, [sp, #-4]!
    BL insert_0
    ADD sp, sp, #8
    LDR r0, [sp, #8]
    BL p_check_null_ptr
    LDR r0, [r0, #4]
    STR r0, [r0]
if_end_1:
    ADD sp, sp, #12
if_end_0:
    LDR r0, [sp, #4]
    ADD sp, sp, #8
    POP {pc}
    .ltorg
printTree_0:
    PUSH {lr}
    SUB sp, sp, #4
    LDR r4, [sp]
    CMP r4, #0
    MOVEQ r4, #1
    MOVNE r4, #0
    CMP r4, #0
    BEQ if_else_2
if_then_2:
    ADD sp, sp, #4
    MOV r0, #0
    POP {pc}
if_then_2_seq_0:
    B if_end_2
if_else_2:
    SUB sp, sp, #12
    LDR r4, [sp, #8]
    MOV r0, r4
    BL p_check_null_ptr
    LDR r4, [r4, #4]
    LDR r4, [r4]
    STR r4, [sp]
    LDR r4, [sp]
    MOV r0, r4
    BL p_check_null_ptr
    LDR r4, [r4]
    LDR r4, [r4]
    STR r4, [sp, #8]
    LDR r4, [sp, #8]
    STR r4, [sp, #-4]!
    BL printTree_0
    ADD sp, sp, #4
    STR r0, [sp, #4]
    LDR r0, [sp, #8]
    BL p_check_null_ptr
    LDR r0, [r0]
    LDR r0, [r0]
    STR r0, [sp, #4]
    LDR r0, [sp, #4]
    MOV r1, r0
    LDR r0, =singleton_1
    ADD r0, r0, #4
    BL printf
    MOV r0, #0
    BL fflush
    MOV r0, #32
    MOV r1, r0
    LDR r0, =singleton_12
    ADD r0, r0, #4
    BL printf
    MOV r0, #0
    BL fflush
    LDR r0, [sp]
    BL p_check_null_ptr
    LDR r0, [r0, #4]
    LDR r0, [r0]
    STR r0, [sp, #8]
    LDR r0, [sp, #8]
    STR r0, [sp, #-4]!
    BL printTree_0
    ADD sp, sp, #4
    STR r0, [sp, #4]
    ADD sp, sp, #12
    MOV r0, #0
    POP {pc}
if_else_2_seq_0:
    ADD sp, sp, #12
    .ltorg
p_runtime_error:
    MOV r0, #-1
    BL exit
p_overflow_error:
    LDR r4, =msg_7
    MOV r1, r4
    ADD r1, r1, #4
    LDR r0, =singleton_4
    ADD r0, r0, #4
    BL printf
    MOV r0, #0
    BL fflush
    BL p_runtime_error
p_check_null_ptr:
    PUSH {lr}
    CMP r0, #0
    BNE not_null_0
p_check_null_ptr_seq_0:
    LDR r4, =msg_8
    MOV r1, r4
    ADD r1, r1, #4
    LDR r0, =singleton_4
    ADD r0, r0, #4
    BL printf
    MOV r0, #0
    BL fflush
    BL p_runtime_error
not_null_0:
    POP {pc}