.data

singleton_0:
    .word 4
    .ascii "%s\n\0"
singleton_1:
    .word 2
    .ascii "%c\0"
singleton_14:
    .word 2
    .ascii "%s\0"
singleton_15:
    .word 3
    .ascii " %c\0"
singleton_18:
    .word 4
    .ascii "%c\n\0"
singleton_36:
    .word 2
    .ascii "%d\0"
singleton_44:
    .word 4
    .ascii "%d\n\0"
msg_0:
    .word 58
    .ascii "Initialising AI. Please wait, this may take a few minutes.\0"
msg_1:
    .word 9
    .ascii " has won!\0"
msg_2:
    .word 10
    .ascii "Stalemate!\0"
msg_3:
    .word 38
    .ascii "========= Tic Tac Toe ================\0"
msg_4:
    .word 38
    .ascii "=  Because we know you want to win   =\0"
msg_5:
    .word 38
    .ascii "======================================\0"
msg_6:
    .word 38
    .ascii "=                                    =\0"
msg_7:
    .word 38
    .ascii "= Who would you like to be?          =\0"
msg_8:
    .word 38
    .ascii "=   x  (play first)                  =\0"
msg_9:
    .word 38
    .ascii "=   o  (play second)                 =\0"
msg_10:
    .word 38
    .ascii "=   q  (quit)                        =\0"
msg_11:
    .word 38
    .ascii "=                                    =\0"
msg_12:
    .word 38
    .ascii "======================================\0"
msg_13:
    .word 39
    .ascii "Which symbol you would like to choose: \0"
msg_14:
    .word 15
    .ascii "Goodbye safety.\0"
msg_15:
    .word 16
    .ascii "Invalid symbol: \0"
msg_16:
    .word 17
    .ascii "Please try again.\0"
msg_17:
    .word 17
    .ascii "You have chosen: \0"
msg_18:
    .word 6
    .ascii " 1 2 3\0"
msg_19:
    .word 1
    .ascii "1\0"
msg_20:
    .word 6
    .ascii " -+-+-\0"
msg_21:
    .word 1
    .ascii "2\0"
msg_22:
    .word 6
    .ascii " -+-+-\0"
msg_23:
    .word 1
    .ascii "3\0"
msg_24:
    .word 0
    .ascii "\0"
msg_25:
    .word 0
    .ascii "\0"
msg_26:
    .word 23
    .ascii "What is your next move?\0"
msg_27:
    .word 12
    .ascii " row (1-3): \0"
msg_28:
    .word 15
    .ascii " column (1-3): \0"
msg_29:
    .word 0
    .ascii "\0"
msg_30:
    .word 39
    .ascii "Your move is invalid. Please try again.\0"
msg_31:
    .word 21
    .ascii "The AI played at row \0"
msg_32:
    .word 8
    .ascii " column \0"
msg_33:
    .word 31
    .ascii "AI is cleaning up its memory...\0"
msg_34:
    .word 52
    .ascii "Internal Error: cannot find the next move for the AI\0"
msg_35:
    .word 31
    .ascii "AI is cleaning up its memory...\0"
msg_36:
    .word 54
    .ascii "Internal Error: symbol given is neither \'x\' or \'o\'\0"
msg_37:
    .word 48
    .ascii "NullReferenceError: dereference a null reference\0"
msg_38:
    .word 42
    .ascii "ArrayIndexOutOfBoundsError: negative index\0"
msg_39:
    .word 43
    .ascii "ArrayIndexOutOfBoundsError: index too large\0"
msg_40:
    .word 81
    .ascii "OverflowError: the result is too small/large to store in a 4-byte signed-integer.\0"
.text

.global main
main:
    PUSH {lr}
    SUB sp, sp, #17
    BL chooseSymbol_0
    MOV r4, r0
    STRB r4, [sp, #15]
    LDRSB r4, [sp, #15]
    STRB r4, [sp, #-1]!
    BL oppositeSymbol_0
    ADD sp, sp, #1
    MOV r4, r0
    STRB r4, [sp, #5]
    MOV r4, #120
    STRB r4, [sp, #16]
    BL allocateNewBoard_0
    MOV r4, r0
    STR r4, [sp, #1]
    LDR r4, =msg_0
    MOV r1, r4
    ADD r1, r1, #4
    LDR r0, =singleton_0
    ADD r0, r0, #4
    BL printf
    MOV r0, #0
    BL fflush
    LDRSB r4, [sp, #5]
    STRB r4, [sp, #-1]!
    BL initAI_0
    ADD sp, sp, #1
    MOV r4, r0
    STR r4, [sp, #6]
    MOV r4, #0
    STR r4, [sp, #10]
    MOV r4, #0
    STRB r4, [sp, #14]
    LDR r4, [sp, #1]
    STR r4, [sp, #-4]!
    BL printBoard_0
    ADD sp, sp, #4
    MOV r4, r0
    STRB r4, [sp]
loop_check_0:
    LDRSB r4, [sp, #14]
    CMP r4, #0
    MOVEQ r4, #1
    MOVNE r4, #0
    LDR r5, [sp, #10]
    CMP r5, #9
    MOVLT r5, #1
    MOVGE r5, #0
    AND r4, r4, r5
    CMP r4, #0
    BEQ loop_end_0
loop_body_0:
    SUB sp, sp, #5
    MOV r0, #12
    BL malloc
    MOV r4, r0
    MOV r5, #0
    STR r5, [r4, #4]
    MOV r5, #0
    STR r5, [r4, #8]
    MOV r5, #2
    STR r5, [r4]
    STR r4, [sp, #1]
    LDR r4, [sp, #1]
    STR r4, [sp, #-4]!
    LDR r4, [sp, #15]
    STR r4, [sp, #-4]!
    LDRSB r4, [sp, #28]
    STRB r4, [sp, #-1]!
    LDRSB r4, [sp, #30]
    STRB r4, [sp, #-1]!
    LDR r4, [sp, #16]
    STR r4, [sp, #-4]!
    BL askForAMove_0
    ADD sp, sp, #14
    MOV r4, r0
    STRB r4, [sp, #5]
    LDR r4, [sp, #1]
    MOV r5, #1
    MOV r0, r5
    MOV r1, r4
    BL p_check_arr_bound
    MOV r6, #4
    SMULL r5, r7, r5, r6
    CMP r7, r5, ASR #31
    BLNE p_overflow_error
    ADD r4, r4, r5
    LDR r4, [r4, #4]
    STR r4, [sp, #-4]!
    LDR r4, [sp, #5]
    MOV r5, #0
    MOV r0, r5
    MOV r1, r4
    BL p_check_arr_bound
    MOV r6, #4
    SMULL r5, r7, r5, r6
    CMP r7, r5, ASR #31
    BLNE p_overflow_error
    ADD r4, r4, r5
    LDR r4, [r4, #4]
    STR r4, [sp, #-4]!
    LDRSB r4, [sp, #29]
    STRB r4, [sp, #-1]!
    LDR r4, [sp, #15]
    STR r4, [sp, #-4]!
    BL placeMove_0
    ADD sp, sp, #13
    MOV r4, r0
    STRB r4, [sp, #5]
    LDR r4, [sp, #1]
    MOV r5, #1
    MOV r0, r5
    MOV r1, r4
    BL p_check_arr_bound
    MOV r6, #4
    SMULL r5, r7, r5, r6
    CMP r7, r5, ASR #31
    BLNE p_overflow_error
    ADD r4, r4, r5
    LDR r4, [r4, #4]
    STR r4, [sp, #-4]!
    LDR r4, [sp, #5]
    MOV r5, #0
    MOV r0, r5
    MOV r1, r4
    BL p_check_arr_bound
    MOV r6, #4
    SMULL r5, r7, r5, r6
    CMP r7, r5, ASR #31
    BLNE p_overflow_error
    ADD r4, r4, r5
    LDR r4, [r4, #4]
    STR r4, [sp, #-4]!
    LDR r4, [sp, #19]
    STR r4, [sp, #-4]!
    LDRSB r4, [sp, #32]
    STRB r4, [sp, #-1]!
    LDRSB r4, [sp, #34]
    STRB r4, [sp, #-1]!
    LDR r4, [sp, #20]
    STR r4, [sp, #-4]!
    BL notifyMove_0
    ADD sp, sp, #18
    MOV r4, r0
    STRB r4, [sp, #5]
    LDR r4, [sp, #6]
    STR r4, [sp, #-4]!
    BL printBoard_0
    ADD sp, sp, #4
    MOV r4, r0
    STRB r4, [sp, #5]
    LDRSB r4, [sp, #21]
    STRB r4, [sp, #-1]!
    LDR r4, [sp, #7]
    STR r4, [sp, #-4]!
    BL hasWon_0
    ADD sp, sp, #5
    MOV r4, r0
    STRB r4, [sp]
    LDRSB r4, [sp]
    CMP r4, #0
    BEQ if_else_0
if_then_0:
    LDRSB r4, [sp, #21]
    STRB r4, [sp, #19]
    B if_end_0
if_else_0:
    
if_end_0:
    LDRSB r4, [sp, #21]
    STRB r4, [sp, #-1]!
    BL oppositeSymbol_0
    ADD sp, sp, #1
    MOV r4, r0
    STRB r4, [sp, #21]
    LDR r4, [sp, #15]
    ADD r4, r4, #1
    BLVS p_overflow_error
    STR r4, [sp, #15]
    ADD sp, sp, #5
    B loop_check_0
loop_end_0:
    LDR r4, [sp, #1]
    STR r4, [sp, #-4]!
    BL freeBoard_0
    ADD sp, sp, #4
    MOV r4, r0
    STRB r4, [sp]
    LDR r4, [sp, #6]
    STR r4, [sp, #-4]!
    BL destroyAI_0
    ADD sp, sp, #4
    MOV r4, r0
    STRB r4, [sp]
    LDRSB r4, [sp, #14]
    CMP r4, #0
    MOVNE r4, #1
    MOVEQ r4, #0
    CMP r4, #0
    BEQ if_else_1
if_then_1:
    LDRSB r4, [sp, #14]
    MOV r1, r4
    LDR r0, =singleton_1
    ADD r0, r0, #4
    BL printf
    MOV r0, #0
    BL fflush
    LDR r4, =msg_1
    MOV r1, r4
    ADD r1, r1, #4
    LDR r0, =singleton_0
    ADD r0, r0, #4
    BL printf
    MOV r0, #0
    BL fflush
    B if_end_1
if_else_1:
    LDR r4, =msg_2
    MOV r1, r4
    ADD r1, r1, #4
    LDR r0, =singleton_0
    ADD r0, r0, #4
    BL printf
    MOV r0, #0
    BL fflush
if_end_1:
    ADD sp, sp, #17
    MOV r0, #0
    POP {pc}
    .ltorg
chooseSymbol_0:
    PUSH {lr}
    LDR r4, =msg_3
    MOV r1, r4
    ADD r1, r1, #4
    LDR r0, =singleton_0
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
    LDR r4, =msg_5
    MOV r1, r4
    ADD r1, r1, #4
    LDR r0, =singleton_0
    ADD r0, r0, #4
    BL printf
    MOV r0, #0
    BL fflush
    LDR r4, =msg_6
    MOV r1, r4
    ADD r1, r1, #4
    LDR r0, =singleton_0
    ADD r0, r0, #4
    BL printf
    MOV r0, #0
    BL fflush
    LDR r4, =msg_7
    MOV r1, r4
    ADD r1, r1, #4
    LDR r0, =singleton_0
    ADD r0, r0, #4
    BL printf
    MOV r0, #0
    BL fflush
    LDR r4, =msg_8
    MOV r1, r4
    ADD r1, r1, #4
    LDR r0, =singleton_0
    ADD r0, r0, #4
    BL printf
    MOV r0, #0
    BL fflush
    LDR r4, =msg_9
    MOV r1, r4
    ADD r1, r1, #4
    LDR r0, =singleton_0
    ADD r0, r0, #4
    BL printf
    MOV r0, #0
    BL fflush
    LDR r4, =msg_10
    MOV r1, r4
    ADD r1, r1, #4
    LDR r0, =singleton_0
    ADD r0, r0, #4
    BL printf
    MOV r0, #0
    BL fflush
    LDR r4, =msg_11
    MOV r1, r4
    ADD r1, r1, #4
    LDR r0, =singleton_0
    ADD r0, r0, #4
    BL printf
    MOV r0, #0
    BL fflush
    LDR r4, =msg_12
    MOV r1, r4
    ADD r1, r1, #4
    LDR r0, =singleton_0
    ADD r0, r0, #4
    BL printf
    MOV r0, #0
    BL fflush
    SUB sp, sp, #1
    MOV r4, #0
    STRB r4, [sp]
loop_check_1:
    LDRSB r4, [sp]
    CMP r4, #0
    MOVEQ r4, #1
    MOVNE r4, #0
    CMP r4, #0
    BEQ loop_end_1
loop_body_1:
    LDR r4, =msg_13
    MOV r1, r4
    ADD r1, r1, #4
    LDR r0, =singleton_14
    ADD r0, r0, #4
    BL printf
    MOV r0, #0
    BL fflush
    SUB sp, sp, #1
    MOV r4, #0
    STRB r4, [sp]
    ADD r1, sp, #0
    LDR r0, =singleton_15
    ADD r0, r0, #4
    BL scanf
    LDRSB r4, [sp]
    CMP r4, #120
    MOVEQ r4, #1
    MOVNE r4, #0
    LDRSB r5, [sp]
    CMP r5, #88
    MOVEQ r5, #1
    MOVNE r5, #0
    ORR r4, r4, r5
    CMP r4, #0
    BEQ if_else_2
if_then_2:
    MOV r4, #120
    STRB r4, [sp, #1]
    B if_end_2
if_else_2:
    LDRSB r4, [sp]
    CMP r4, #111
    MOVEQ r4, #1
    MOVNE r4, #0
    LDRSB r5, [sp]
    CMP r5, #79
    MOVEQ r5, #1
    MOVNE r5, #0
    ORR r4, r4, r5
    CMP r4, #0
    BEQ if_else_3
if_then_3:
    MOV r4, #111
    STRB r4, [sp, #1]
    B if_end_3
if_else_3:
    LDRSB r4, [sp]
    CMP r4, #113
    MOVEQ r4, #1
    MOVNE r4, #0
    LDRSB r5, [sp]
    CMP r5, #81
    MOVEQ r5, #1
    MOVNE r5, #0
    ORR r4, r4, r5
    CMP r4, #0
    BEQ if_else_4
if_then_4:
    LDR r4, =msg_14
    MOV r1, r4
    ADD r1, r1, #4
    LDR r0, =singleton_0
    ADD r0, r0, #4
    BL printf
    MOV r0, #0
    BL fflush
    MOV r0, #0
    BL exit
    B if_end_4
if_else_4:
    LDR r4, =msg_15
    MOV r1, r4
    ADD r1, r1, #4
    LDR r0, =singleton_14
    ADD r0, r0, #4
    BL printf
    MOV r0, #0
    BL fflush
    LDRSB r4, [sp]
    MOV r1, r4
    LDR r0, =singleton_18
    ADD r0, r0, #4
    BL printf
    MOV r0, #0
    BL fflush
    LDR r4, =msg_16
    MOV r1, r4
    ADD r1, r1, #4
    LDR r0, =singleton_0
    ADD r0, r0, #4
    BL printf
    MOV r0, #0
    BL fflush
if_end_4:
    
if_end_3:
    
if_end_2:
    ADD sp, sp, #1
    B loop_check_1
loop_end_1:
    LDR r4, =msg_17
    MOV r1, r4
    ADD r1, r1, #4
    LDR r0, =singleton_14
    ADD r0, r0, #4
    BL printf
    MOV r0, #0
    BL fflush
    LDRSB r4, [sp]
    MOV r1, r4
    LDR r0, =singleton_18
    ADD r0, r0, #4
    BL printf
    MOV r0, #0
    BL fflush
    LDRSB r4, [sp]
    ADD sp, sp, #1
    MOV r0, r4
    POP {pc}
    .ltorg
printBoard_0:
    PUSH {lr}
    SUB sp, sp, #17
    LDR r4, [sp, #21]
    MOV r0, r4
    BL p_check_null_ptr
    LDR r4, [r4]
    LDR r4, [r4]
    STR r4, [sp, #9]
    LDR r4, [sp, #9]
    MOV r0, r4
    BL p_check_null_ptr
    LDR r4, [r4]
    LDR r4, [r4]
    STR r4, [sp, #13]
    LDR r4, [sp, #9]
    MOV r0, r4
    BL p_check_null_ptr
    LDR r4, [r4, #4]
    LDR r4, [r4]
    STR r4, [sp, #1]
    LDR r4, [sp, #21]
    MOV r0, r4
    BL p_check_null_ptr
    LDR r4, [r4, #4]
    LDR r4, [r4]
    STR r4, [sp, #5]
    LDR r4, =msg_18
    MOV r1, r4
    ADD r1, r1, #4
    LDR r0, =singleton_0
    ADD r0, r0, #4
    BL printf
    MOV r0, #0
    BL fflush
    LDR r4, =msg_19
    MOV r1, r4
    ADD r1, r1, #4
    LDR r0, =singleton_14
    ADD r0, r0, #4
    BL printf
    MOV r0, #0
    BL fflush
    LDR r4, [sp, #13]
    STR r4, [sp, #-4]!
    BL printRow_0
    ADD sp, sp, #4
    MOV r4, r0
    STRB r4, [sp]
    LDR r4, =msg_20
    MOV r1, r4
    ADD r1, r1, #4
    LDR r0, =singleton_0
    ADD r0, r0, #4
    BL printf
    MOV r0, #0
    BL fflush
    LDR r4, =msg_21
    MOV r1, r4
    ADD r1, r1, #4
    LDR r0, =singleton_14
    ADD r0, r0, #4
    BL printf
    MOV r0, #0
    BL fflush
    LDR r4, [sp, #1]
    STR r4, [sp, #-4]!
    BL printRow_0
    ADD sp, sp, #4
    MOV r4, r0
    STRB r4, [sp]
    LDR r4, =msg_22
    MOV r1, r4
    ADD r1, r1, #4
    LDR r0, =singleton_0
    ADD r0, r0, #4
    BL printf
    MOV r0, #0
    BL fflush
    LDR r4, =msg_23
    MOV r1, r4
    ADD r1, r1, #4
    LDR r0, =singleton_14
    ADD r0, r0, #4
    BL printf
    MOV r0, #0
    BL fflush
    LDR r4, [sp, #5]
    STR r4, [sp, #-4]!
    BL printRow_0
    ADD sp, sp, #4
    MOV r4, r0
    STRB r4, [sp]
    LDR r4, =msg_24
    MOV r1, r4
    ADD r1, r1, #4
    LDR r0, =singleton_0
    ADD r0, r0, #4
    BL printf
    MOV r0, #0
    BL fflush
    ADD sp, sp, #17
    MOV r0, #1
    POP {pc}
    .ltorg
printRow_0:
    PUSH {lr}
    SUB sp, sp, #8
    LDR r4, [sp, #12]
    MOV r0, r4
    BL p_check_null_ptr
    LDR r4, [r4]
    LDR r4, [r4]
    STR r4, [sp, #2]
    LDR r4, [sp, #2]
    MOV r0, r4
    BL p_check_null_ptr
    LDR r4, [r4]
    LDRSB r4, [r4]
    STRB r4, [sp, #1]
    LDR r4, [sp, #2]
    MOV r0, r4
    BL p_check_null_ptr
    LDR r4, [r4, #4]
    LDRSB r4, [r4]
    STRB r4, [sp, #7]
    LDR r4, [sp, #12]
    MOV r0, r4
    BL p_check_null_ptr
    LDR r4, [r4, #4]
    LDRSB r4, [r4]
    STRB r4, [sp, #6]
    LDRSB r4, [sp, #1]
    STRB r4, [sp, #-1]!
    BL printCell_0
    ADD sp, sp, #1
    MOV r4, r0
    STRB r4, [sp]
    MOV r4, #124
    MOV r1, r4
    LDR r0, =singleton_1
    ADD r0, r0, #4
    BL printf
    MOV r0, #0
    BL fflush
    LDRSB r4, [sp, #7]
    STRB r4, [sp, #-1]!
    BL printCell_0
    ADD sp, sp, #1
    MOV r4, r0
    STRB r4, [sp]
    MOV r4, #124
    MOV r1, r4
    LDR r0, =singleton_1
    ADD r0, r0, #4
    BL printf
    MOV r0, #0
    BL fflush
    LDRSB r4, [sp, #6]
    STRB r4, [sp, #-1]!
    BL printCell_0
    ADD sp, sp, #1
    MOV r4, r0
    STRB r4, [sp]
    LDR r4, =msg_25
    MOV r1, r4
    ADD r1, r1, #4
    LDR r0, =singleton_0
    ADD r0, r0, #4
    BL printf
    MOV r0, #0
    BL fflush
    ADD sp, sp, #8
    MOV r0, #1
    POP {pc}
    .ltorg
printCell_0:
    PUSH {lr}
    LDRSB r4, [sp, #4]
    CMP r4, #0
    MOVEQ r4, #1
    MOVNE r4, #0
    CMP r4, #0
    BEQ if_else_5
if_then_5:
    MOV r4, #32
    MOV r1, r4
    LDR r0, =singleton_1
    ADD r0, r0, #4
    BL printf
    MOV r0, #0
    BL fflush
    B if_end_5
if_else_5:
    LDRSB r4, [sp, #4]
    MOV r1, r4
    LDR r0, =singleton_1
    ADD r0, r0, #4
    BL printf
    MOV r0, #0
    BL fflush
if_end_5:
    MOV r0, #1
    POP {pc}
    .ltorg
askForAMoveHuman_0:
    PUSH {lr}
    SUB sp, sp, #9
    MOV r4, #0
    STRB r4, [sp, #8]
    MOV r4, #0
    STR r4, [sp]
    MOV r4, #0
    STR r4, [sp, #4]
loop_check_2:
    LDRSB r4, [sp, #8]
    EOR r4, r4, #1
    CMP r4, #0
    BEQ loop_end_2
loop_body_2:
    LDR r4, =msg_26
    MOV r1, r4
    ADD r1, r1, #4
    LDR r0, =singleton_0
    ADD r0, r0, #4
    BL printf
    MOV r0, #0
    BL fflush
    LDR r4, =msg_27
    MOV r1, r4
    ADD r1, r1, #4
    LDR r0, =singleton_14
    ADD r0, r0, #4
    BL printf
    MOV r0, #0
    BL fflush
    ADD r1, sp, #0
    LDR r0, =singleton_36
    ADD r0, r0, #4
    BL scanf
    LDR r4, =msg_28
    MOV r1, r4
    ADD r1, r1, #4
    LDR r0, =singleton_14
    ADD r0, r0, #4
    BL printf
    MOV r0, #0
    BL fflush
    ADD r1, sp, #4
    LDR r0, =singleton_36
    ADD r0, r0, #4
    BL scanf
    LDR r4, [sp, #4]
    STR r4, [sp, #-4]!
    LDR r4, [sp, #4]
    STR r4, [sp, #-4]!
    LDR r4, [sp, #21]
    STR r4, [sp, #-4]!
    BL validateMove_0
    ADD sp, sp, #12
    MOV r4, r0
    STRB r4, [sp, #8]
    LDRSB r4, [sp, #8]
    CMP r4, #0
    BEQ if_else_6
if_then_6:
    LDR r4, =msg_29
    MOV r1, r4
    ADD r1, r1, #4
    LDR r0, =singleton_0
    ADD r0, r0, #4
    BL printf
    MOV r0, #0
    BL fflush
    LDR r4, [sp]
    MOV r5, #0
    LDR r6, [sp, #17]
    MOV r0, r5
    MOV r1, r6
    BL p_check_arr_bound
    MOV r7, #4
    SMULL r5, r8, r5, r7
    CMP r8, r5, ASR #31
    BLNE p_overflow_error
    ADD r5, r5, #4
    ADD r6, r6, r5
    STR r4, [r6]
    LDR r4, [sp, #4]
    MOV r5, #1
    LDR r6, [sp, #17]
    MOV r0, r5
    MOV r1, r6
    BL p_check_arr_bound
    MOV r7, #4
    SMULL r5, r8, r5, r7
    CMP r8, r5, ASR #31
    BLNE p_overflow_error
    ADD r5, r5, #4
    ADD r6, r6, r5
    STR r4, [r6]
    ADD sp, sp, #9
    MOV r0, #1
    POP {pc}
if_then_6_seq_0:
    B if_end_6
if_else_6:
    LDR r4, =msg_30
    MOV r1, r4
    ADD r1, r1, #4
    LDR r0, =singleton_0
    ADD r0, r0, #4
    BL printf
    MOV r0, #0
    BL fflush
if_end_6:
    B loop_check_2
loop_end_2:
    ADD sp, sp, #9
    MOV r0, #1
    POP {pc}
    .ltorg
validateMove_0:
    PUSH {lr}
    MOV r4, #1
    LDR r5, [sp, #8]
    CMP r4, r5
    MOVLE r4, #1
    MOVGT r4, #0
    LDR r5, [sp, #8]
    CMP r5, #3
    MOVLE r5, #1
    MOVGT r5, #0
    AND r4, r4, r5
    MOV r5, #1
    LDR r6, [sp, #12]
    CMP r5, r6
    MOVLE r5, #1
    MOVGT r5, #0
    AND r4, r4, r5
    LDR r5, [sp, #12]
    CMP r5, #3
    MOVLE r5, #1
    MOVGT r5, #0
    AND r4, r4, r5
    CMP r4, #0
    BEQ if_else_7
if_then_7:
    SUB sp, sp, #1
    LDR r4, [sp, #13]
    STR r4, [sp, #-4]!
    LDR r4, [sp, #13]
    STR r4, [sp, #-4]!
    LDR r4, [sp, #13]
    STR r4, [sp, #-4]!
    BL symbolAt_0
    ADD sp, sp, #12
    MOV r4, r0
    STRB r4, [sp]
    LDRSB r4, [sp]
    CMP r4, #0
    MOVEQ r4, #1
    MOVNE r4, #0
    ADD sp, sp, #1
    MOV r0, r4
    POP {pc}
if_then_7_seq_0:
    ADD sp, sp, #1
    B if_end_7
if_else_7:
    MOV r0, #0
    POP {pc}
if_else_7_seq_0:
    
if_end_7:
    .ltorg
notifyMoveHuman_0:
    PUSH {lr}
    LDR r4, =msg_31
    MOV r1, r4
    ADD r1, r1, #4
    LDR r0, =singleton_14
    ADD r0, r0, #4
    BL printf
    MOV r0, #0
    BL fflush
    LDR r4, [sp, #10]
    MOV r1, r4
    LDR r0, =singleton_36
    ADD r0, r0, #4
    BL printf
    MOV r0, #0
    BL fflush
    LDR r4, =msg_32
    MOV r1, r4
    ADD r1, r1, #4
    LDR r0, =singleton_14
    ADD r0, r0, #4
    BL printf
    MOV r0, #0
    BL fflush
    LDR r4, [sp, #14]
    MOV r1, r4
    LDR r0, =singleton_44
    ADD r0, r0, #4
    BL printf
    MOV r0, #0
    BL fflush
    MOV r0, #1
    POP {pc}
    .ltorg
initAI_0:
    PUSH {lr}
    SUB sp, sp, #16
    MOV r0, #8
    BL malloc
    MOV r4, r0
    LDRSB r5, [sp, #20]
    MOV r0, #1
    BL malloc
    STRB r5, [r0]
    STR r0, [r4]
    MOV r5, #0
    MOV r0, #4
    BL malloc
    STR r5, [r0]
    STR r0, [r4, #4]
    STR r4, [sp]
    LDRSB r4, [sp, #20]
    STRB r4, [sp, #-1]!
    BL generateAllPossibleStates_0
    ADD sp, sp, #1
    MOV r4, r0
    STR r4, [sp, #12]
    MOV r4, #120
    STRB r4, [sp, #-1]!
    LDRSB r4, [sp, #21]
    STRB r4, [sp, #-1]!
    LDR r4, [sp, #14]
    STR r4, [sp, #-4]!
    BL setValuesForAllStates_0
    ADD sp, sp, #6
    MOV r4, r0
    STR r4, [sp, #4]
    MOV r0, #8
    BL malloc
    MOV r4, r0
    LDR r5, [sp]
    MOV r0, #4
    BL malloc
    STR r5, [r0]
    STR r0, [r4]
    LDR r5, [sp, #12]
    MOV r0, #4
    BL malloc
    STR r5, [r0]
    STR r0, [r4, #4]
    STR r4, [sp, #8]
    LDR r4, [sp, #8]
    ADD sp, sp, #16
    MOV r0, r4
    POP {pc}
    .ltorg
generateAllPossibleStates_0:
    PUSH {lr}
    SUB sp, sp, #8
    BL allocateNewBoard_0
    MOV r4, r0
    STR r4, [sp]
    LDR r4, [sp]
    STR r4, [sp, #-4]!
    BL convertFromBoardToState_0
    ADD sp, sp, #4
    MOV r4, r0
    STR r4, [sp, #4]
    MOV r4, #120
    STRB r4, [sp, #-1]!
    LDR r4, [sp, #5]
    STR r4, [sp, #-4]!
    BL generateNextStates_0
    ADD sp, sp, #5
    MOV r4, r0
    STR r4, [sp, #4]
    LDR r4, [sp, #4]
    ADD sp, sp, #8
    MOV r0, r4
    POP {pc}
    .ltorg
convertFromBoardToState_0:
    PUSH {lr}
    SUB sp, sp, #12
    BL generateEmptyPointerBoard_0
    MOV r4, r0
    STR r4, [sp]
    MOV r0, #8
    BL malloc
    MOV r4, r0
    LDR r5, [sp, #16]
    MOV r0, #4
    BL malloc
    STR r5, [r0]
    STR r0, [r4]
    LDR r5, [sp]
    MOV r0, #4
    BL malloc
    STR r5, [r0]
    STR r0, [r4, #4]
    STR r4, [sp, #8]
    MOV r0, #8
    BL malloc
    MOV r4, r0
    LDR r5, [sp, #8]
    MOV r0, #4
    BL malloc
    STR r5, [r0]
    STR r0, [r4]
    MOV r5, #0
    MOV r0, #4
    BL malloc
    STR r5, [r0]
    STR r0, [r4, #4]
    STR r4, [sp, #4]
    LDR r4, [sp, #4]
    ADD sp, sp, #12
    MOV r0, r4
    POP {pc}
    .ltorg
generateEmptyPointerBoard_0:
    PUSH {lr}
    SUB sp, sp, #20
    BL generateEmptyPointerRow_0
    MOV r4, r0
    STR r4, [sp, #16]
    BL generateEmptyPointerRow_0
    MOV r4, r0
    STR r4, [sp]
    BL generateEmptyPointerRow_0
    MOV r4, r0
    STR r4, [sp, #4]
    MOV r0, #8
    BL malloc
    MOV r4, r0
    LDR r5, [sp, #16]
    MOV r0, #4
    BL malloc
    STR r5, [r0]
    STR r0, [r4]
    LDR r5, [sp]
    MOV r0, #4
    BL malloc
    STR r5, [r0]
    STR r0, [r4, #4]
    STR r4, [sp, #8]
    MOV r0, #8
    BL malloc
    MOV r4, r0
    LDR r5, [sp, #8]
    MOV r0, #4
    BL malloc
    STR r5, [r0]
    STR r0, [r4]
    LDR r5, [sp, #4]
    MOV r0, #4
    BL malloc
    STR r5, [r0]
    STR r0, [r4, #4]
    STR r4, [sp, #12]
    LDR r4, [sp, #12]
    ADD sp, sp, #20
    MOV r0, r4
    POP {pc}
    .ltorg
generateEmptyPointerRow_0:
    PUSH {lr}
    SUB sp, sp, #8
    MOV r0, #8
    BL malloc
    MOV r4, r0
    MOV r5, #0
    MOV r0, #4
    BL malloc
    STR r5, [r0]
    STR r0, [r4]
    MOV r5, #0
    MOV r0, #4
    BL malloc
    STR r5, [r0]
    STR r0, [r4, #4]
    STR r4, [sp]
    MOV r0, #8
    BL malloc
    MOV r4, r0
    LDR r5, [sp]
    MOV r0, #4
    BL malloc
    STR r5, [r0]
    STR r0, [r4]
    MOV r5, #0
    MOV r0, #4
    BL malloc
    STR r5, [r0]
    STR r0, [r4, #4]
    STR r4, [sp, #4]
    LDR r4, [sp, #4]
    ADD sp, sp, #8
    MOV r0, r4
    POP {pc}
    .ltorg
generateNextStates_0:
    PUSH {lr}
    SUB sp, sp, #14
    LDR r4, [sp, #18]
    MOV r0, r4
    BL p_check_null_ptr
    LDR r4, [r4]
    LDR r4, [r4]
    STR r4, [sp, #9]
    LDR r4, [sp, #9]
    MOV r0, r4
    BL p_check_null_ptr
    LDR r4, [r4]
    LDR r4, [r4]
    STR r4, [sp, #5]
    LDR r4, [sp, #9]
    MOV r0, r4
    BL p_check_null_ptr
    LDR r4, [r4, #4]
    LDR r4, [r4]
    STR r4, [sp, #1]
    LDRSB r4, [sp, #22]
    STRB r4, [sp, #-1]!
    BL oppositeSymbol_0
    ADD sp, sp, #1
    MOV r4, r0
    STRB r4, [sp]
    LDRSB r4, [sp]
    STRB r4, [sp, #-1]!
    LDR r4, [sp, #6]
    STR r4, [sp, #-4]!
    BL hasWon_0
    ADD sp, sp, #5
    MOV r4, r0
    STRB r4, [sp, #13]
    LDRSB r4, [sp, #13]
    CMP r4, #0
    BEQ if_else_8
if_then_8:
    LDR r4, [sp, #18]
    ADD sp, sp, #14
    MOV r0, r4
    POP {pc}
if_then_8_seq_0:
    B if_end_8
if_else_8:
    SUB sp, sp, #1
    LDRSB r4, [sp, #23]
    STRB r4, [sp, #-1]!
    LDR r4, [sp, #3]
    STR r4, [sp, #-4]!
    LDR r4, [sp, #11]
    STR r4, [sp, #-4]!
    BL generateNextStatesBoard_0
    ADD sp, sp, #9
    MOV r4, r0
    STRB r4, [sp]
    LDR r4, [sp, #19]
    ADD sp, sp, #15
    MOV r0, r4
    POP {pc}
if_else_8_seq_0:
    ADD sp, sp, #1
if_end_8:
    .ltorg
generateNextStatesBoard_0:
    PUSH {lr}
    SUB sp, sp, #33
    LDR r4, [sp, #37]
    MOV r0, r4
    BL p_check_null_ptr
    LDR r4, [r4]
    LDR r4, [r4]
    STR r4, [sp, #17]
    LDR r4, [sp, #17]
    MOV r0, r4
    BL p_check_null_ptr
    LDR r4, [r4]
    LDR r4, [r4]
    STR r4, [sp, #29]
    LDR r4, [sp, #17]
    MOV r0, r4
    BL p_check_null_ptr
    LDR r4, [r4, #4]
    LDR r4, [r4]
    STR r4, [sp, #9]
    LDR r4, [sp, #37]
    MOV r0, r4
    BL p_check_null_ptr
    LDR r4, [r4, #4]
    LDR r4, [r4]
    STR r4, [sp, #13]
    LDR r4, [sp, #41]
    MOV r0, r4
    BL p_check_null_ptr
    LDR r4, [r4]
    LDR r4, [r4]
    STR r4, [sp, #1]
    LDR r4, [sp, #1]
    MOV r0, r4
    BL p_check_null_ptr
    LDR r4, [r4]
    LDR r4, [r4]
    STR r4, [sp, #21]
    LDR r4, [sp, #1]
    MOV r0, r4
    BL p_check_null_ptr
    LDR r4, [r4, #4]
    LDR r4, [r4]
    STR r4, [sp, #25]
    LDR r4, [sp, #41]
    MOV r0, r4
    BL p_check_null_ptr
    LDR r4, [r4, #4]
    LDR r4, [r4]
    STR r4, [sp, #5]
    MOV r4, #1
    STR r4, [sp, #-4]!
    LDRSB r4, [sp, #49]
    STRB r4, [sp, #-1]!
    LDR r4, [sp, #26]
    STR r4, [sp, #-4]!
    LDR r4, [sp, #38]
    STR r4, [sp, #-4]!
    LDR r4, [sp, #50]
    STR r4, [sp, #-4]!
    BL generateNextStatesRow_0
    ADD sp, sp, #17
    MOV r4, r0
    STRB r4, [sp]
    MOV r4, #2
    STR r4, [sp, #-4]!
    LDRSB r4, [sp, #49]
    STRB r4, [sp, #-1]!
    LDR r4, [sp, #30]
    STR r4, [sp, #-4]!
    LDR r4, [sp, #18]
    STR r4, [sp, #-4]!
    LDR r4, [sp, #50]
    STR r4, [sp, #-4]!
    BL generateNextStatesRow_0
    ADD sp, sp, #17
    MOV r4, r0
    STRB r4, [sp]
    MOV r4, #3
    STR r4, [sp, #-4]!
    LDRSB r4, [sp, #49]
    STRB r4, [sp, #-1]!
    LDR r4, [sp, #10]
    STR r4, [sp, #-4]!
    LDR r4, [sp, #22]
    STR r4, [sp, #-4]!
    LDR r4, [sp, #50]
    STR r4, [sp, #-4]!
    BL generateNextStatesRow_0
    ADD sp, sp, #17
    MOV r4, r0
    STRB r4, [sp]
    ADD sp, sp, #33
    MOV r0, #1
    POP {pc}
    .ltorg
generateNextStatesRow_0:
    PUSH {lr}
    SUB sp, sp, #11
    LDR r4, [sp, #19]
    MOV r0, r4
    BL p_check_null_ptr
    LDR r4, [r4]
    LDR r4, [r4]
    STR r4, [sp, #5]
    LDR r4, [sp, #5]
    MOV r0, r4
    BL p_check_null_ptr
    LDR r4, [r4]
    LDRSB r4, [r4]
    STRB r4, [sp, #4]
    LDR r4, [sp, #5]
    MOV r0, r4
    BL p_check_null_ptr
    LDR r4, [r4, #4]
    LDRSB r4, [r4]
    STRB r4, [sp, #10]
    LDR r4, [sp, #19]
    MOV r0, r4
    BL p_check_null_ptr
    LDR r4, [r4, #4]
    LDRSB r4, [r4]
    STRB r4, [sp, #9]
    LDR r4, [sp, #23]
    MOV r0, r4
    BL p_check_null_ptr
    LDR r4, [r4]
    LDR r4, [r4]
    STR r4, [sp]
    MOV r4, #1
    STR r4, [sp, #-4]!
    LDR r4, [sp, #32]
    STR r4, [sp, #-4]!
    LDRSB r4, [sp, #35]
    STRB r4, [sp, #-1]!
    LDRSB r4, [sp, #13]
    STRB r4, [sp, #-1]!
    LDR r4, [sp, #25]
    STR r4, [sp, #-4]!
    BL generateNextStatesCell_0
    ADD sp, sp, #14
    MOV r4, r0
    LDR r5, [sp]
    MOV r0, r5
    BL p_check_null_ptr
    LDR r5, [r5]
    STR r4, [r5]
    MOV r4, #2
    STR r4, [sp, #-4]!
    LDR r4, [sp, #32]
    STR r4, [sp, #-4]!
    LDRSB r4, [sp, #35]
    STRB r4, [sp, #-1]!
    LDRSB r4, [sp, #19]
    STRB r4, [sp, #-1]!
    LDR r4, [sp, #25]
    STR r4, [sp, #-4]!
    BL generateNextStatesCell_0
    ADD sp, sp, #14
    MOV r4, r0
    LDR r5, [sp]
    MOV r0, r5
    BL p_check_null_ptr
    LDR r5, [r5, #4]
    STR r4, [r5]
    MOV r4, #3
    STR r4, [sp, #-4]!
    LDR r4, [sp, #32]
    STR r4, [sp, #-4]!
    LDRSB r4, [sp, #35]
    STRB r4, [sp, #-1]!
    LDRSB r4, [sp, #18]
    STRB r4, [sp, #-1]!
    LDR r4, [sp, #25]
    STR r4, [sp, #-4]!
    BL generateNextStatesCell_0
    ADD sp, sp, #14
    MOV r4, r0
    LDR r5, [sp, #23]
    MOV r0, r5
    BL p_check_null_ptr
    LDR r5, [r5, #4]
    STR r4, [r5]
    ADD sp, sp, #11
    MOV r0, #1
    POP {pc}
    .ltorg
generateNextStatesCell_0:
    PUSH {lr}
    LDRSB r4, [sp, #8]
    CMP r4, #0
    MOVEQ r4, #1
    MOVNE r4, #0
    CMP r4, #0
    BEQ if_else_9
if_then_9:
    SUB sp, sp, #10
    LDR r4, [sp, #14]
    STR r4, [sp, #-4]!
    BL cloneBoard_0
    ADD sp, sp, #4
    MOV r4, r0
    STR r4, [sp, #5]
    LDR r4, [sp, #24]
    STR r4, [sp, #-4]!
    LDR r4, [sp, #24]
    STR r4, [sp, #-4]!
    LDRSB r4, [sp, #27]
    STRB r4, [sp, #-1]!
    LDR r4, [sp, #14]
    STR r4, [sp, #-4]!
    BL placeMove_0
    ADD sp, sp, #13
    MOV r4, r0
    STRB r4, [sp]
    LDR r4, [sp, #5]
    STR r4, [sp, #-4]!
    BL convertFromBoardToState_0
    ADD sp, sp, #4
    MOV r4, r0
    STR r4, [sp, #1]
    LDRSB r4, [sp, #19]
    STRB r4, [sp, #-1]!
    BL oppositeSymbol_0
    ADD sp, sp, #1
    MOV r4, r0
    STRB r4, [sp, #9]
    LDRSB r4, [sp, #9]
    STRB r4, [sp, #-1]!
    LDR r4, [sp, #2]
    STR r4, [sp, #-4]!
    BL generateNextStates_0
    ADD sp, sp, #5
    MOV r4, r0
    STR r4, [sp, #1]
    LDR r4, [sp, #1]
    ADD sp, sp, #10
    MOV r0, r4
    POP {pc}
if_then_9_seq_0:
    ADD sp, sp, #10
    B if_end_9
if_else_9:
    MOV r0, #0
    POP {pc}
if_else_9_seq_0:
    
if_end_9:
    .ltorg
cloneBoard_0:
    PUSH {lr}
    SUB sp, sp, #5
    BL allocateNewBoard_0
    MOV r4, r0
    STR r4, [sp, #1]
    LDR r4, [sp, #1]
    STR r4, [sp, #-4]!
    LDR r4, [sp, #13]
    STR r4, [sp, #-4]!
    BL copyBoard_0
    ADD sp, sp, #8
    MOV r4, r0
    STRB r4, [sp]
    LDR r4, [sp, #1]
    ADD sp, sp, #5
    MOV r0, r4
    POP {pc}
    .ltorg
copyBoard_0:
    PUSH {lr}
    SUB sp, sp, #33
    LDR r4, [sp, #37]
    MOV r0, r4
    BL p_check_null_ptr
    LDR r4, [r4]
    LDR r4, [r4]
    STR r4, [sp, #25]
    LDR r4, [sp, #25]
    MOV r0, r4
    BL p_check_null_ptr
    LDR r4, [r4]
    LDR r4, [r4]
    STR r4, [sp, #5]
    LDR r4, [sp, #25]
    MOV r0, r4
    BL p_check_null_ptr
    LDR r4, [r4, #4]
    LDR r4, [r4]
    STR r4, [sp, #9]
    LDR r4, [sp, #37]
    MOV r0, r4
    BL p_check_null_ptr
    LDR r4, [r4, #4]
    LDR r4, [r4]
    STR r4, [sp, #17]
    LDR r4, [sp, #41]
    MOV r0, r4
    BL p_check_null_ptr
    LDR r4, [r4]
    LDR r4, [r4]
    STR r4, [sp, #29]
    LDR r4, [sp, #29]
    MOV r0, r4
    BL p_check_null_ptr
    LDR r4, [r4]
    LDR r4, [r4]
    STR r4, [sp, #13]
    LDR r4, [sp, #29]
    MOV r0, r4
    BL p_check_null_ptr
    LDR r4, [r4, #4]
    LDR r4, [r4]
    STR r4, [sp, #21]
    LDR r4, [sp, #41]
    MOV r0, r4
    BL p_check_null_ptr
    LDR r4, [r4, #4]
    LDR r4, [r4]
    STR r4, [sp, #1]
    LDR r4, [sp, #13]
    STR r4, [sp, #-4]!
    LDR r4, [sp, #9]
    STR r4, [sp, #-4]!
    BL copyRow_0
    ADD sp, sp, #8
    MOV r4, r0
    STRB r4, [sp]
    LDR r4, [sp, #21]
    STR r4, [sp, #-4]!
    LDR r4, [sp, #13]
    STR r4, [sp, #-4]!
    BL copyRow_0
    ADD sp, sp, #8
    MOV r4, r0
    STRB r4, [sp]
    LDR r4, [sp, #1]
    STR r4, [sp, #-4]!
    LDR r4, [sp, #21]
    STR r4, [sp, #-4]!
    BL copyRow_0
    ADD sp, sp, #8
    MOV r4, r0
    STRB r4, [sp]
    ADD sp, sp, #33
    MOV r0, #1
    POP {pc}
    .ltorg
copyRow_0:
    PUSH {lr}
    SUB sp, sp, #8
    LDR r4, [sp, #12]
    MOV r0, r4
    BL p_check_null_ptr
    LDR r4, [r4]
    LDR r4, [r4]
    STR r4, [sp]
    LDR r4, [sp, #16]
    MOV r0, r4
    BL p_check_null_ptr
    LDR r4, [r4]
    LDR r4, [r4]
    STR r4, [sp, #4]
    LDR r4, [sp]
    MOV r0, r4
    BL p_check_null_ptr
    LDR r4, [r4]
    LDRSB r4, [r4]
    LDR r5, [sp, #4]
    MOV r0, r5
    BL p_check_null_ptr
    LDR r5, [r5]
    STRB r4, [r5]
    LDR r4, [sp]
    MOV r0, r4
    BL p_check_null_ptr
    LDR r4, [r4, #4]
    LDRSB r4, [r4]
    LDR r5, [sp, #4]
    MOV r0, r5
    BL p_check_null_ptr
    LDR r5, [r5, #4]
    STRB r4, [r5]
    LDR r4, [sp, #12]
    MOV r0, r4
    BL p_check_null_ptr
    LDR r4, [r4, #4]
    LDRSB r4, [r4]
    LDR r5, [sp, #16]
    MOV r0, r5
    BL p_check_null_ptr
    LDR r5, [r5, #4]
    STRB r4, [r5]
    ADD sp, sp, #8
    MOV r0, #1
    POP {pc}
    .ltorg
setValuesForAllStates_0:
    PUSH {lr}
    SUB sp, sp, #4
    MOV r4, #0
    STR r4, [sp]
    LDR r4, [sp, #8]
    CMP r4, #0
    MOVEQ r4, #1
    MOVNE r4, #0
    CMP r4, #0
    BEQ if_else_10
if_then_10:
    LDRSB r4, [sp, #13]
    LDRSB r5, [sp, #12]
    CMP r4, r5
    MOVEQ r4, #1
    MOVNE r4, #0
    CMP r4, #0
    BEQ if_else_11
if_then_11:
    MOV r4, #101
    STR r4, [sp]
    B if_end_11
if_else_11:
    LDR r4, =-101
    STR r4, [sp]
if_end_11:
    B if_end_10
if_else_10:
    SUB sp, sp, #14
    LDR r4, [sp, #22]
    MOV r0, r4
    BL p_check_null_ptr
    LDR r4, [r4]
    LDR r4, [r4]
    STR r4, [sp, #9]
    LDR r4, [sp, #9]
    MOV r0, r4
    BL p_check_null_ptr
    LDR r4, [r4]
    LDR r4, [r4]
    STR r4, [sp, #4]
    LDR r4, [sp, #9]
    MOV r0, r4
    BL p_check_null_ptr
    LDR r4, [r4, #4]
    LDR r4, [r4]
    STR r4, [sp]
    LDRSB r4, [sp, #27]
    STRB r4, [sp, #-1]!
    BL oppositeSymbol_0
    ADD sp, sp, #1
    MOV r4, r0
    STRB r4, [sp, #8]
    LDRSB r4, [sp, #8]
    STRB r4, [sp, #-1]!
    LDR r4, [sp, #5]
    STR r4, [sp, #-4]!
    BL hasWon_0
    ADD sp, sp, #5
    MOV r4, r0
    STRB r4, [sp, #13]
    LDRSB r4, [sp, #13]
    CMP r4, #0
    BEQ if_else_12
if_then_12:
    LDRSB r4, [sp, #8]
    LDRSB r5, [sp, #26]
    CMP r4, r5
    MOVEQ r4, #1
    MOVNE r4, #0
    CMP r4, #0
    BEQ if_else_13
if_then_13:
    MOV r4, #100
    STR r4, [sp, #14]
    B if_end_13
if_else_13:
    LDR r4, =-100
    STR r4, [sp, #14]
if_end_13:
    B if_end_12
if_else_12:
    SUB sp, sp, #1
    LDR r4, [sp, #5]
    STR r4, [sp, #-4]!
    BL containEmptyCell_0
    ADD sp, sp, #4
    MOV r4, r0
    STRB r4, [sp]
    LDRSB r4, [sp]
    CMP r4, #0
    BEQ if_else_14
if_then_14:
    LDRSB r4, [sp, #9]
    STRB r4, [sp, #-1]!
    LDRSB r4, [sp, #28]
    STRB r4, [sp, #-1]!
    LDR r4, [sp, #3]
    STR r4, [sp, #-4]!
    BL calculateValuesFromNextStates_0
    ADD sp, sp, #6
    MOV r4, r0
    STR r4, [sp, #15]
    LDR r4, [sp, #15]
    CMP r4, #100
    MOVEQ r4, #1
    MOVNE r4, #0
    CMP r4, #0
    BEQ if_else_15
if_then_15:
    MOV r4, #90
    STR r4, [sp, #15]
    B if_end_15
if_else_15:
    
if_end_15:
    B if_end_14
if_else_14:
    MOV r4, #0
    STR r4, [sp, #15]
if_end_14:
    ADD sp, sp, #1
if_end_12:
    LDR r4, [sp, #14]
    LDR r5, [sp, #22]
    MOV r0, r5
    BL p_check_null_ptr
    LDR r5, [r5, #4]
    STR r4, [r5]
    ADD sp, sp, #14
if_end_10:
    LDR r4, [sp]
    ADD sp, sp, #4
    MOV r0, r4
    POP {pc}
    .ltorg
calculateValuesFromNextStates_0:
    PUSH {lr}
    SUB sp, sp, #32
    LDR r4, [sp, #36]
    MOV r0, r4
    BL p_check_null_ptr
    LDR r4, [r4]
    LDR r4, [r4]
    STR r4, [sp, #12]
    LDR r4, [sp, #12]
    MOV r0, r4
    BL p_check_null_ptr
    LDR r4, [r4]
    LDR r4, [r4]
    STR r4, [sp, #28]
    LDR r4, [sp, #12]
    MOV r0, r4
    BL p_check_null_ptr
    LDR r4, [r4, #4]
    LDR r4, [r4]
    STR r4, [sp, #4]
    LDR r4, [sp, #36]
    MOV r0, r4
    BL p_check_null_ptr
    LDR r4, [r4, #4]
    LDR r4, [r4]
    STR r4, [sp, #8]
    LDRSB r4, [sp, #41]
    STRB r4, [sp, #-1]!
    LDRSB r4, [sp, #41]
    STRB r4, [sp, #-1]!
    LDR r4, [sp, #30]
    STR r4, [sp, #-4]!
    BL calculateValuesFromNextStatesRow_0
    ADD sp, sp, #6
    MOV r4, r0
    STR r4, [sp, #20]
    LDRSB r4, [sp, #41]
    STRB r4, [sp, #-1]!
    LDRSB r4, [sp, #41]
    STRB r4, [sp, #-1]!
    LDR r4, [sp, #6]
    STR r4, [sp, #-4]!
    BL calculateValuesFromNextStatesRow_0
    ADD sp, sp, #6
    MOV r4, r0
    STR r4, [sp, #24]
    LDRSB r4, [sp, #41]
    STRB r4, [sp, #-1]!
    LDRSB r4, [sp, #41]
    STRB r4, [sp, #-1]!
    LDR r4, [sp, #10]
    STR r4, [sp, #-4]!
    BL calculateValuesFromNextStatesRow_0
    ADD sp, sp, #6
    MOV r4, r0
    STR r4, [sp, #16]
    LDR r4, [sp, #16]
    STR r4, [sp, #-4]!
    LDR r4, [sp, #28]
    STR r4, [sp, #-4]!
    LDR r4, [sp, #28]
    STR r4, [sp, #-4]!
    LDRSB r4, [sp, #53]
    STRB r4, [sp, #-1]!
    LDRSB r4, [sp, #53]
    STRB r4, [sp, #-1]!
    BL combineValue_0
    ADD sp, sp, #14
    MOV r4, r0
    STR r4, [sp]
    LDR r4, [sp]
    ADD sp, sp, #32
    MOV r0, r4
    POP {pc}
    .ltorg
calculateValuesFromNextStatesRow_0:
    PUSH {lr}
    SUB sp, sp, #32
    LDR r4, [sp, #36]
    MOV r0, r4
    BL p_check_null_ptr
    LDR r4, [r4]
    LDR r4, [r4]
    STR r4, [sp, #16]
    LDR r4, [sp, #16]
    MOV r0, r4
    BL p_check_null_ptr
    LDR r4, [r4]
    LDR r4, [r4]
    STR r4, [sp, #8]
    LDR r4, [sp, #16]
    MOV r0, r4
    BL p_check_null_ptr
    LDR r4, [r4, #4]
    LDR r4, [r4]
    STR r4, [sp, #12]
    LDR r4, [sp, #36]
    MOV r0, r4
    BL p_check_null_ptr
    LDR r4, [r4, #4]
    LDR r4, [r4]
    STR r4, [sp, #4]
    LDRSB r4, [sp, #41]
    STRB r4, [sp, #-1]!
    LDRSB r4, [sp, #41]
    STRB r4, [sp, #-1]!
    LDR r4, [sp, #10]
    STR r4, [sp, #-4]!
    BL setValuesForAllStates_0
    ADD sp, sp, #6
    MOV r4, r0
    STR r4, [sp, #24]
    LDRSB r4, [sp, #41]
    STRB r4, [sp, #-1]!
    LDRSB r4, [sp, #41]
    STRB r4, [sp, #-1]!
    LDR r4, [sp, #14]
    STR r4, [sp, #-4]!
    BL setValuesForAllStates_0
    ADD sp, sp, #6
    MOV r4, r0
    STR r4, [sp, #28]
    LDRSB r4, [sp, #41]
    STRB r4, [sp, #-1]!
    LDRSB r4, [sp, #41]
    STRB r4, [sp, #-1]!
    LDR r4, [sp, #6]
    STR r4, [sp, #-4]!
    BL setValuesForAllStates_0
    ADD sp, sp, #6
    MOV r4, r0
    STR r4, [sp, #20]
    LDR r4, [sp, #20]
    STR r4, [sp, #-4]!
    LDR r4, [sp, #32]
    STR r4, [sp, #-4]!
    LDR r4, [sp, #32]
    STR r4, [sp, #-4]!
    LDRSB r4, [sp, #53]
    STRB r4, [sp, #-1]!
    LDRSB r4, [sp, #53]
    STRB r4, [sp, #-1]!
    BL combineValue_0
    ADD sp, sp, #14
    MOV r4, r0
    STR r4, [sp]
    LDR r4, [sp]
    ADD sp, sp, #32
    MOV r0, r4
    POP {pc}
    .ltorg
combineValue_0:
    PUSH {lr}
    SUB sp, sp, #4
    MOV r4, #0
    STR r4, [sp]
    LDRSB r4, [sp, #8]
    LDRSB r5, [sp, #9]
    CMP r4, r5
    MOVEQ r4, #1
    MOVNE r4, #0
    CMP r4, #0
    BEQ if_else_16
if_then_16:
    LDR r4, [sp, #18]
    STR r4, [sp, #-4]!
    LDR r4, [sp, #18]
    STR r4, [sp, #-4]!
    LDR r4, [sp, #18]
    STR r4, [sp, #-4]!
    BL min3_0
    ADD sp, sp, #12
    MOV r4, r0
    STR r4, [sp]
    B if_end_16
if_else_16:
    LDR r4, [sp, #18]
    STR r4, [sp, #-4]!
    LDR r4, [sp, #18]
    STR r4, [sp, #-4]!
    LDR r4, [sp, #18]
    STR r4, [sp, #-4]!
    BL max3_0
    ADD sp, sp, #12
    MOV r4, r0
    STR r4, [sp]
if_end_16:
    LDR r4, [sp]
    ADD sp, sp, #4
    MOV r0, r4
    POP {pc}
    .ltorg
min3_0:
    PUSH {lr}
    LDR r4, [sp, #4]
    LDR r5, [sp, #8]
    CMP r4, r5
    MOVLT r4, #1
    MOVGE r4, #0
    CMP r4, #0
    BEQ if_else_17
if_then_17:
    LDR r4, [sp, #4]
    LDR r5, [sp, #12]
    CMP r4, r5
    MOVLT r4, #1
    MOVGE r4, #0
    CMP r4, #0
    BEQ if_else_18
if_then_18:
    LDR r4, [sp, #4]
    MOV r0, r4
    POP {pc}
if_then_18_seq_0:
    B if_end_18
if_else_18:
    LDR r4, [sp, #12]
    MOV r0, r4
    POP {pc}
if_else_18_seq_0:
    
if_end_18:
    B if_end_17
if_else_17:
    LDR r4, [sp, #8]
    LDR r5, [sp, #12]
    CMP r4, r5
    MOVLT r4, #1
    MOVGE r4, #0
    CMP r4, #0
    BEQ if_else_19
if_then_19:
    LDR r4, [sp, #8]
    MOV r0, r4
    POP {pc}
if_then_19_seq_0:
    B if_end_19
if_else_19:
    LDR r4, [sp, #12]
    MOV r0, r4
    POP {pc}
if_else_19_seq_0:
    
if_end_19:
    
if_end_17:
    .ltorg
max3_0:
    PUSH {lr}
    LDR r4, [sp, #4]
    LDR r5, [sp, #8]
    CMP r4, r5
    MOVGT r4, #1
    MOVLE r4, #0
    CMP r4, #0
    BEQ if_else_20
if_then_20:
    LDR r4, [sp, #4]
    LDR r5, [sp, #12]
    CMP r4, r5
    MOVGT r4, #1
    MOVLE r4, #0
    CMP r4, #0
    BEQ if_else_21
if_then_21:
    LDR r4, [sp, #4]
    MOV r0, r4
    POP {pc}
if_then_21_seq_0:
    B if_end_21
if_else_21:
    LDR r4, [sp, #12]
    MOV r0, r4
    POP {pc}
if_else_21_seq_0:
    
if_end_21:
    B if_end_20
if_else_20:
    LDR r4, [sp, #8]
    LDR r5, [sp, #12]
    CMP r4, r5
    MOVGT r4, #1
    MOVLE r4, #0
    CMP r4, #0
    BEQ if_else_22
if_then_22:
    LDR r4, [sp, #8]
    MOV r0, r4
    POP {pc}
if_then_22_seq_0:
    B if_end_22
if_else_22:
    LDR r4, [sp, #12]
    MOV r0, r4
    POP {pc}
if_else_22_seq_0:
    
if_end_22:
    
if_end_20:
    .ltorg
destroyAI_0:
    PUSH {lr}
    SUB sp, sp, #9
    LDR r4, [sp, #13]
    MOV r0, r4
    BL p_check_null_ptr
    LDR r4, [r4]
    LDR r4, [r4]
    STR r4, [sp, #1]
    LDR r4, [sp, #13]
    MOV r0, r4
    BL p_check_null_ptr
    LDR r4, [r4, #4]
    LDR r4, [r4]
    STR r4, [sp, #5]
    LDR r4, [sp, #5]
    STR r4, [sp, #-4]!
    BL deleteStateTreeRecursively_0
    ADD sp, sp, #4
    MOV r4, r0
    STRB r4, [sp]
    LDR r4, [sp, #1]
    MOV r0, r4
    BL p_free_pair
    LDR r4, [sp, #13]
    MOV r0, r4
    BL p_free_pair
    ADD sp, sp, #9
    MOV r0, #1
    POP {pc}
    .ltorg
askForAMoveAI_0:
    PUSH {lr}
    SUB sp, sp, #21
    LDR r4, [sp, #31]
    MOV r0, r4
    BL p_check_null_ptr
    LDR r4, [r4]
    LDR r4, [r4]
    STR r4, [sp, #1]
    LDR r4, [sp, #31]
    MOV r0, r4
    BL p_check_null_ptr
    LDR r4, [r4, #4]
    LDR r4, [r4]
    STR r4, [sp, #17]
    LDR r4, [sp, #17]
    MOV r0, r4
    BL p_check_null_ptr
    LDR r4, [r4]
    LDR r4, [r4]
    STR r4, [sp, #9]
    LDR r4, [sp, #9]
    MOV r0, r4
    BL p_check_null_ptr
    LDR r4, [r4, #4]
    LDR r4, [r4]
    STR r4, [sp, #5]
    LDR r4, [sp, #17]
    MOV r0, r4
    BL p_check_null_ptr
    LDR r4, [r4, #4]
    LDR r4, [r4]
    STR r4, [sp, #13]
    LDR r4, [sp, #35]
    STR r4, [sp, #-4]!
    LDR r4, [sp, #17]
    STR r4, [sp, #-4]!
    LDR r4, [sp, #13]
    STR r4, [sp, #-4]!
    BL findTheBestMove_0
    ADD sp, sp, #12
    MOV r4, r0
    STRB r4, [sp]
    LDR r4, =msg_33
    MOV r1, r4
    ADD r1, r1, #4
    LDR r0, =singleton_0
    ADD r0, r0, #4
    BL printf
    MOV r0, #0
    BL fflush
    LDR r4, [sp, #35]
    MOV r5, #1
    MOV r0, r5
    MOV r1, r4
    BL p_check_arr_bound
    MOV r6, #4
    SMULL r5, r7, r5, r6
    CMP r7, r5, ASR #31
    BLNE p_overflow_error
    ADD r4, r4, r5
    LDR r4, [r4, #4]
    STR r4, [sp, #-4]!
    LDR r4, [sp, #39]
    MOV r5, #0
    MOV r0, r5
    MOV r1, r4
    BL p_check_arr_bound
    MOV r6, #4
    SMULL r5, r7, r5, r6
    CMP r7, r5, ASR #31
    BLNE p_overflow_error
    ADD r4, r4, r5
    LDR r4, [r4, #4]
    STR r4, [sp, #-4]!
    LDR r4, [sp, #13]
    STR r4, [sp, #-4]!
    BL deleteAllOtherChildren_0
    ADD sp, sp, #12
    MOV r4, r0
    LDR r5, [sp, #31]
    MOV r0, r5
    BL p_check_null_ptr
    LDR r5, [r5, #4]
    STR r4, [r5]
    LDR r4, [sp, #17]
    STR r4, [sp, #-4]!
    BL deleteThisStateOnly_0
    ADD sp, sp, #4
    MOV r4, r0
    STRB r4, [sp]
    ADD sp, sp, #21
    MOV r0, #1
    POP {pc}
    .ltorg
findTheBestMove_0:
    PUSH {lr}
    SUB sp, sp, #1
    LDR r4, [sp, #9]
    CMP r4, #90
    MOVEQ r4, #1
    MOVNE r4, #0
    CMP r4, #0
    BEQ if_else_23
if_then_23:
    SUB sp, sp, #1
    LDR r4, [sp, #14]
    STR r4, [sp, #-4]!
    MOV r4, #100
    STR r4, [sp, #-4]!
    LDR r4, [sp, #14]
    STR r4, [sp, #-4]!
    BL findMoveWithGivenValue_0
    ADD sp, sp, #12
    MOV r4, r0
    STRB r4, [sp]
    LDRSB r4, [sp]
    CMP r4, #0
    BEQ if_else_24
if_then_24:
    ADD sp, sp, #2
    MOV r0, #1
    POP {pc}
if_then_24_seq_0:
    B if_end_24
if_else_24:
    
if_end_24:
    ADD sp, sp, #1
    B if_end_23
if_else_23:
    
if_end_23:
    LDR r4, [sp, #13]
    STR r4, [sp, #-4]!
    LDR r4, [sp, #13]
    STR r4, [sp, #-4]!
    LDR r4, [sp, #13]
    STR r4, [sp, #-4]!
    BL findMoveWithGivenValue_0
    ADD sp, sp, #12
    MOV r4, r0
    STRB r4, [sp]
    LDRSB r4, [sp]
    CMP r4, #0
    BEQ if_else_25
if_then_25:
    ADD sp, sp, #1
    MOV r0, #1
    POP {pc}
if_then_25_seq_0:
    B if_end_25
if_else_25:
    LDR r4, =msg_34
    MOV r1, r4
    ADD r1, r1, #4
    LDR r0, =singleton_0
    ADD r0, r0, #4
    BL printf
    MOV r0, #0
    BL fflush
    LDR r4, =-1
    MOV r0, r4
    BL exit
if_end_25:
    .ltorg
findMoveWithGivenValue_0:
    PUSH {lr}
    SUB sp, sp, #17
    LDR r4, [sp, #21]
    MOV r0, r4
    BL p_check_null_ptr
    LDR r4, [r4]
    LDR r4, [r4]
    STR r4, [sp, #8]
    LDR r4, [sp, #8]
    MOV r0, r4
    BL p_check_null_ptr
    LDR r4, [r4]
    LDR r4, [r4]
    STR r4, [sp, #13]
    LDR r4, [sp, #8]
    MOV r0, r4
    BL p_check_null_ptr
    LDR r4, [r4, #4]
    LDR r4, [r4]
    STR r4, [sp]
    LDR r4, [sp, #21]
    MOV r0, r4
    BL p_check_null_ptr
    LDR r4, [r4, #4]
    LDR r4, [r4]
    STR r4, [sp, #4]
    LDR r4, [sp, #29]
    STR r4, [sp, #-4]!
    LDR r4, [sp, #29]
    STR r4, [sp, #-4]!
    LDR r4, [sp, #21]
    STR r4, [sp, #-4]!
    BL findMoveWithGivenValueRow_0
    ADD sp, sp, #12
    MOV r4, r0
    STRB r4, [sp, #12]
    LDRSB r4, [sp, #12]
    CMP r4, #0
    BEQ if_else_26
if_then_26:
    MOV r4, #1
    MOV r5, #0
    LDR r6, [sp, #29]
    MOV r0, r5
    MOV r1, r6
    BL p_check_arr_bound
    MOV r7, #4
    SMULL r5, r8, r5, r7
    CMP r8, r5, ASR #31
    BLNE p_overflow_error
    ADD r5, r5, #4
    ADD r6, r6, r5
    STR r4, [r6]
    B if_end_26
if_else_26:
    LDR r4, [sp, #29]
    STR r4, [sp, #-4]!
    LDR r4, [sp, #29]
    STR r4, [sp, #-4]!
    LDR r4, [sp, #8]
    STR r4, [sp, #-4]!
    BL findMoveWithGivenValueRow_0
    ADD sp, sp, #12
    MOV r4, r0
    STRB r4, [sp, #12]
    LDRSB r4, [sp, #12]
    CMP r4, #0
    BEQ if_else_27
if_then_27:
    MOV r4, #2
    MOV r5, #0
    LDR r6, [sp, #29]
    MOV r0, r5
    MOV r1, r6
    BL p_check_arr_bound
    MOV r7, #4
    SMULL r5, r8, r5, r7
    CMP r8, r5, ASR #31
    BLNE p_overflow_error
    ADD r5, r5, #4
    ADD r6, r6, r5
    STR r4, [r6]
    B if_end_27
if_else_27:
    LDR r4, [sp, #29]
    STR r4, [sp, #-4]!
    LDR r4, [sp, #29]
    STR r4, [sp, #-4]!
    LDR r4, [sp, #12]
    STR r4, [sp, #-4]!
    BL findMoveWithGivenValueRow_0
    ADD sp, sp, #12
    MOV r4, r0
    STRB r4, [sp, #12]
    LDRSB r4, [sp, #12]
    CMP r4, #0
    BEQ if_else_28
if_then_28:
    MOV r4, #3
    MOV r5, #0
    LDR r6, [sp, #29]
    MOV r0, r5
    MOV r1, r6
    BL p_check_arr_bound
    MOV r7, #4
    SMULL r5, r8, r5, r7
    CMP r8, r5, ASR #31
    BLNE p_overflow_error
    ADD r5, r5, #4
    ADD r6, r6, r5
    STR r4, [r6]
    B if_end_28
if_else_28:
    ADD sp, sp, #17
    MOV r0, #0
    POP {pc}
if_else_28_seq_0:
    
if_end_28:
    
if_end_27:
    
if_end_26:
    ADD sp, sp, #17
    MOV r0, #1
    POP {pc}
    .ltorg
findMoveWithGivenValueRow_0:
    PUSH {lr}
    SUB sp, sp, #17
    LDR r4, [sp, #21]
    MOV r0, r4
    BL p_check_null_ptr
    LDR r4, [r4]
    LDR r4, [r4]
    STR r4, [sp, #4]
    LDR r4, [sp, #4]
    MOV r0, r4
    BL p_check_null_ptr
    LDR r4, [r4]
    LDR r4, [r4]
    STR r4, [sp]
    LDR r4, [sp, #4]
    MOV r0, r4
    BL p_check_null_ptr
    LDR r4, [r4, #4]
    LDR r4, [r4]
    STR r4, [sp, #13]
    LDR r4, [sp, #21]
    MOV r0, r4
    BL p_check_null_ptr
    LDR r4, [r4, #4]
    LDR r4, [r4]
    STR r4, [sp, #9]
    LDR r4, [sp, #25]
    STR r4, [sp, #-4]!
    LDR r4, [sp, #4]
    STR r4, [sp, #-4]!
    BL hasGivenStateValue_0
    ADD sp, sp, #8
    MOV r4, r0
    STRB r4, [sp, #8]
    LDRSB r4, [sp, #8]
    CMP r4, #0
    BEQ if_else_29
if_then_29:
    MOV r4, #1
    MOV r5, #1
    LDR r6, [sp, #29]
    MOV r0, r5
    MOV r1, r6
    BL p_check_arr_bound
    MOV r7, #4
    SMULL r5, r8, r5, r7
    CMP r8, r5, ASR #31
    BLNE p_overflow_error
    ADD r5, r5, #4
    ADD r6, r6, r5
    STR r4, [r6]
    B if_end_29
if_else_29:
    LDR r4, [sp, #25]
    STR r4, [sp, #-4]!
    LDR r4, [sp, #17]
    STR r4, [sp, #-4]!
    BL hasGivenStateValue_0
    ADD sp, sp, #8
    MOV r4, r0
    STRB r4, [sp, #8]
    LDRSB r4, [sp, #8]
    CMP r4, #0
    BEQ if_else_30
if_then_30:
    MOV r4, #2
    MOV r5, #1
    LDR r6, [sp, #29]
    MOV r0, r5
    MOV r1, r6
    BL p_check_arr_bound
    MOV r7, #4
    SMULL r5, r8, r5, r7
    CMP r8, r5, ASR #31
    BLNE p_overflow_error
    ADD r5, r5, #4
    ADD r6, r6, r5
    STR r4, [r6]
    B if_end_30
if_else_30:
    LDR r4, [sp, #25]
    STR r4, [sp, #-4]!
    LDR r4, [sp, #13]
    STR r4, [sp, #-4]!
    BL hasGivenStateValue_0
    ADD sp, sp, #8
    MOV r4, r0
    STRB r4, [sp, #8]
    LDRSB r4, [sp, #8]
    CMP r4, #0
    BEQ if_else_31
if_then_31:
    MOV r4, #3
    MOV r5, #1
    LDR r6, [sp, #29]
    MOV r0, r5
    MOV r1, r6
    BL p_check_arr_bound
    MOV r7, #4
    SMULL r5, r8, r5, r7
    CMP r8, r5, ASR #31
    BLNE p_overflow_error
    ADD r5, r5, #4
    ADD r6, r6, r5
    STR r4, [r6]
    B if_end_31
if_else_31:
    ADD sp, sp, #17
    MOV r0, #0
    POP {pc}
if_else_31_seq_0:
    
if_end_31:
    
if_end_30:
    
if_end_29:
    ADD sp, sp, #17
    MOV r0, #1
    POP {pc}
    .ltorg
hasGivenStateValue_0:
    PUSH {lr}
    LDR r4, [sp, #4]
    CMP r4, #0
    MOVEQ r4, #1
    MOVNE r4, #0
    CMP r4, #0
    BEQ if_else_32
if_then_32:
    MOV r0, #0
    POP {pc}
if_then_32_seq_0:
    B if_end_32
if_else_32:
    SUB sp, sp, #4
    LDR r4, [sp, #8]
    MOV r0, r4
    BL p_check_null_ptr
    LDR r4, [r4, #4]
    LDR r4, [r4]
    STR r4, [sp]
    LDR r4, [sp]
    LDR r5, [sp, #12]
    CMP r4, r5
    MOVEQ r4, #1
    MOVNE r4, #0
    ADD sp, sp, #4
    MOV r0, r4
    POP {pc}
if_else_32_seq_0:
    ADD sp, sp, #4
if_end_32:
    .ltorg
notifyMoveAI_0:
    PUSH {lr}
    SUB sp, sp, #13
    LDR r4, [sp, #23]
    MOV r0, r4
    BL p_check_null_ptr
    LDR r4, [r4, #4]
    LDR r4, [r4]
    STR r4, [sp, #9]
    LDR r4, [sp, #9]
    MOV r0, r4
    BL p_check_null_ptr
    LDR r4, [r4]
    LDR r4, [r4]
    STR r4, [sp, #5]
    LDR r4, [sp, #5]
    MOV r0, r4
    BL p_check_null_ptr
    LDR r4, [r4, #4]
    LDR r4, [r4]
    STR r4, [sp, #1]
    LDR r4, =msg_35
    MOV r1, r4
    ADD r1, r1, #4
    LDR r0, =singleton_0
    ADD r0, r0, #4
    BL printf
    MOV r0, #0
    BL fflush
    LDR r4, [sp, #31]
    STR r4, [sp, #-4]!
    LDR r4, [sp, #31]
    STR r4, [sp, #-4]!
    LDR r4, [sp, #9]
    STR r4, [sp, #-4]!
    BL deleteAllOtherChildren_0
    ADD sp, sp, #12
    MOV r4, r0
    LDR r5, [sp, #23]
    MOV r0, r5
    BL p_check_null_ptr
    LDR r5, [r5, #4]
    STR r4, [r5]
    LDR r4, [sp, #9]
    STR r4, [sp, #-4]!
    BL deleteThisStateOnly_0
    ADD sp, sp, #4
    MOV r4, r0
    STRB r4, [sp]
    ADD sp, sp, #13
    MOV r0, #1
    POP {pc}
    .ltorg
deleteAllOtherChildren_0:
    PUSH {lr}
    SUB sp, sp, #33
    LDR r4, [sp, #37]
    MOV r0, r4
    BL p_check_null_ptr
    LDR r4, [r4]
    LDR r4, [r4]
    STR r4, [sp, #21]
    LDR r4, [sp, #21]
    MOV r0, r4
    BL p_check_null_ptr
    LDR r4, [r4]
    LDR r4, [r4]
    STR r4, [sp, #29]
    LDR r4, [sp, #21]
    MOV r0, r4
    BL p_check_null_ptr
    LDR r4, [r4, #4]
    LDR r4, [r4]
    STR r4, [sp, #9]
    LDR r4, [sp, #37]
    MOV r0, r4
    BL p_check_null_ptr
    LDR r4, [r4, #4]
    LDR r4, [r4]
    STR r4, [sp, #13]
    MOV r4, #0
    STR r4, [sp, #5]
    MOV r4, #0
    STR r4, [sp, #17]
    MOV r4, #0
    STR r4, [sp, #25]
    LDR r4, [sp, #41]
    CMP r4, #1
    MOVEQ r4, #1
    MOVNE r4, #0
    CMP r4, #0
    BEQ if_else_33
if_then_33:
    LDR r4, [sp, #29]
    STR r4, [sp, #5]
    LDR r4, [sp, #9]
    STR r4, [sp, #17]
    LDR r4, [sp, #13]
    STR r4, [sp, #25]
    B if_end_33
if_else_33:
    LDR r4, [sp, #29]
    STR r4, [sp, #17]
    LDR r4, [sp, #41]
    CMP r4, #2
    MOVEQ r4, #1
    MOVNE r4, #0
    CMP r4, #0
    BEQ if_else_34
if_then_34:
    LDR r4, [sp, #9]
    STR r4, [sp, #5]
    LDR r4, [sp, #13]
    STR r4, [sp, #25]
    B if_end_34
if_else_34:
    LDR r4, [sp, #13]
    STR r4, [sp, #5]
    LDR r4, [sp, #9]
    STR r4, [sp, #25]
if_end_34:
    
if_end_33:
    LDR r4, [sp, #45]
    STR r4, [sp, #-4]!
    LDR r4, [sp, #9]
    STR r4, [sp, #-4]!
    BL deleteAllOtherChildrenRow_0
    ADD sp, sp, #8
    MOV r4, r0
    STR r4, [sp, #1]
    LDR r4, [sp, #17]
    STR r4, [sp, #-4]!
    BL deleteChildrenStateRecursivelyRow_0
    ADD sp, sp, #4
    MOV r4, r0
    STRB r4, [sp]
    LDR r4, [sp, #25]
    STR r4, [sp, #-4]!
    BL deleteChildrenStateRecursivelyRow_0
    ADD sp, sp, #4
    MOV r4, r0
    STRB r4, [sp]
    LDR r4, [sp, #1]
    ADD sp, sp, #33
    MOV r0, r4
    POP {pc}
    .ltorg
deleteAllOtherChildrenRow_0:
    PUSH {lr}
    SUB sp, sp, #29
    LDR r4, [sp, #33]
    MOV r0, r4
    BL p_check_null_ptr
    LDR r4, [r4]
    LDR r4, [r4]
    STR r4, [sp, #5]
    LDR r4, [sp, #5]
    MOV r0, r4
    BL p_check_null_ptr
    LDR r4, [r4]
    LDR r4, [r4]
    STR r4, [sp, #1]
    LDR r4, [sp, #5]
    MOV r0, r4
    BL p_check_null_ptr
    LDR r4, [r4, #4]
    LDR r4, [r4]
    STR r4, [sp, #25]
    LDR r4, [sp, #33]
    MOV r0, r4
    BL p_check_null_ptr
    LDR r4, [r4, #4]
    LDR r4, [r4]
    STR r4, [sp, #21]
    MOV r4, #0
    STR r4, [sp, #17]
    MOV r4, #0
    STR r4, [sp, #13]
    MOV r4, #0
    STR r4, [sp, #9]
    LDR r4, [sp, #37]
    CMP r4, #1
    MOVEQ r4, #1
    MOVNE r4, #0
    CMP r4, #0
    BEQ if_else_35
if_then_35:
    LDR r4, [sp, #1]
    STR r4, [sp, #17]
    LDR r4, [sp, #25]
    STR r4, [sp, #13]
    LDR r4, [sp, #21]
    STR r4, [sp, #9]
    B if_end_35
if_else_35:
    LDR r4, [sp, #1]
    STR r4, [sp, #13]
    LDR r4, [sp, #37]
    CMP r4, #2
    MOVEQ r4, #1
    MOVNE r4, #0
    CMP r4, #0
    BEQ if_else_36
if_then_36:
    LDR r4, [sp, #25]
    STR r4, [sp, #17]
    LDR r4, [sp, #21]
    STR r4, [sp, #9]
    B if_end_36
if_else_36:
    LDR r4, [sp, #21]
    STR r4, [sp, #17]
    LDR r4, [sp, #25]
    STR r4, [sp, #9]
if_end_36:
    
if_end_35:
    LDR r4, [sp, #13]
    STR r4, [sp, #-4]!
    BL deleteStateTreeRecursively_0
    ADD sp, sp, #4
    MOV r4, r0
    STRB r4, [sp]
    LDR r4, [sp, #9]
    STR r4, [sp, #-4]!
    BL deleteStateTreeRecursively_0
    ADD sp, sp, #4
    MOV r4, r0
    STRB r4, [sp]
    LDR r4, [sp, #17]
    ADD sp, sp, #29
    MOV r0, r4
    POP {pc}
    .ltorg
deleteStateTreeRecursively_0:
    PUSH {lr}
    LDR r4, [sp, #4]
    CMP r4, #0
    MOVEQ r4, #1
    MOVNE r4, #0
    CMP r4, #0
    BEQ if_else_37
if_then_37:
    MOV r0, #1
    POP {pc}
if_then_37_seq_0:
    B if_end_37
if_else_37:
    SUB sp, sp, #13
    LDR r4, [sp, #17]
    MOV r0, r4
    BL p_check_null_ptr
    LDR r4, [r4]
    LDR r4, [r4]
    STR r4, [sp, #9]
    LDR r4, [sp, #9]
    MOV r0, r4
    BL p_check_null_ptr
    LDR r4, [r4]
    LDR r4, [r4]
    STR r4, [sp, #5]
    LDR r4, [sp, #9]
    MOV r0, r4
    BL p_check_null_ptr
    LDR r4, [r4, #4]
    LDR r4, [r4]
    STR r4, [sp, #1]
    LDR r4, [sp, #1]
    STR r4, [sp, #-4]!
    BL deleteChildrenStateRecursively_0
    ADD sp, sp, #4
    MOV r4, r0
    STRB r4, [sp]
    LDR r4, [sp, #17]
    STR r4, [sp, #-4]!
    BL deleteThisStateOnly_0
    ADD sp, sp, #4
    MOV r4, r0
    STRB r4, [sp]
    ADD sp, sp, #13
    MOV r0, #1
    POP {pc}
if_else_37_seq_0:
    ADD sp, sp, #13
if_end_37:
    .ltorg
deleteThisStateOnly_0:
    PUSH {lr}
    SUB sp, sp, #13
    LDR r4, [sp, #17]
    MOV r0, r4
    BL p_check_null_ptr
    LDR r4, [r4]
    LDR r4, [r4]
    STR r4, [sp, #9]
    LDR r4, [sp, #9]
    MOV r0, r4
    BL p_check_null_ptr
    LDR r4, [r4]
    LDR r4, [r4]
    STR r4, [sp, #5]
    LDR r4, [sp, #9]
    MOV r0, r4
    BL p_check_null_ptr
    LDR r4, [r4, #4]
    LDR r4, [r4]
    STR r4, [sp, #1]
    LDR r4, [sp, #5]
    STR r4, [sp, #-4]!
    BL freeBoard_0
    ADD sp, sp, #4
    MOV r4, r0
    STRB r4, [sp]
    LDR r4, [sp, #1]
    STR r4, [sp, #-4]!
    BL freePointers_0
    ADD sp, sp, #4
    MOV r4, r0
    STRB r4, [sp]
    LDR r4, [sp, #9]
    MOV r0, r4
    BL p_free_pair
    LDR r4, [sp, #17]
    MOV r0, r4
    BL p_free_pair
    ADD sp, sp, #13
    MOV r0, #1
    POP {pc}
    .ltorg
freePointers_0:
    PUSH {lr}
    SUB sp, sp, #17
    LDR r4, [sp, #21]
    MOV r0, r4
    BL p_check_null_ptr
    LDR r4, [r4]
    LDR r4, [r4]
    STR r4, [sp, #9]
    LDR r4, [sp, #9]
    MOV r0, r4
    BL p_check_null_ptr
    LDR r4, [r4]
    LDR r4, [r4]
    STR r4, [sp, #13]
    LDR r4, [sp, #9]
    MOV r0, r4
    BL p_check_null_ptr
    LDR r4, [r4, #4]
    LDR r4, [r4]
    STR r4, [sp, #1]
    LDR r4, [sp, #21]
    MOV r0, r4
    BL p_check_null_ptr
    LDR r4, [r4, #4]
    LDR r4, [r4]
    STR r4, [sp, #5]
    LDR r4, [sp, #13]
    STR r4, [sp, #-4]!
    BL freePointersRow_0
    ADD sp, sp, #4
    MOV r4, r0
    STRB r4, [sp]
    LDR r4, [sp, #1]
    STR r4, [sp, #-4]!
    BL freePointersRow_0
    ADD sp, sp, #4
    MOV r4, r0
    STRB r4, [sp]
    LDR r4, [sp, #5]
    STR r4, [sp, #-4]!
    BL freePointersRow_0
    ADD sp, sp, #4
    MOV r4, r0
    STRB r4, [sp]
    LDR r4, [sp, #9]
    MOV r0, r4
    BL p_free_pair
    LDR r4, [sp, #21]
    MOV r0, r4
    BL p_free_pair
    ADD sp, sp, #17
    MOV r0, #1
    POP {pc}
    .ltorg
freePointersRow_0:
    PUSH {lr}
    SUB sp, sp, #4
    LDR r4, [sp, #8]
    MOV r0, r4
    BL p_check_null_ptr
    LDR r4, [r4]
    LDR r4, [r4]
    STR r4, [sp]
    LDR r4, [sp]
    MOV r0, r4
    BL p_free_pair
    LDR r4, [sp, #8]
    MOV r0, r4
    BL p_free_pair
    ADD sp, sp, #4
    MOV r0, #1
    POP {pc}
    .ltorg
deleteChildrenStateRecursively_0:
    PUSH {lr}
    SUB sp, sp, #17
    LDR r4, [sp, #21]
    MOV r0, r4
    BL p_check_null_ptr
    LDR r4, [r4]
    LDR r4, [r4]
    STR r4, [sp, #9]
    LDR r4, [sp, #9]
    MOV r0, r4
    BL p_check_null_ptr
    LDR r4, [r4]
    LDR r4, [r4]
    STR r4, [sp, #13]
    LDR r4, [sp, #9]
    MOV r0, r4
    BL p_check_null_ptr
    LDR r4, [r4, #4]
    LDR r4, [r4]
    STR r4, [sp, #1]
    LDR r4, [sp, #21]
    MOV r0, r4
    BL p_check_null_ptr
    LDR r4, [r4, #4]
    LDR r4, [r4]
    STR r4, [sp, #5]
    LDR r4, [sp, #13]
    STR r4, [sp, #-4]!
    BL deleteChildrenStateRecursivelyRow_0
    ADD sp, sp, #4
    MOV r4, r0
    STRB r4, [sp]
    LDR r4, [sp, #1]
    STR r4, [sp, #-4]!
    BL deleteChildrenStateRecursivelyRow_0
    ADD sp, sp, #4
    MOV r4, r0
    STRB r4, [sp]
    LDR r4, [sp, #5]
    STR r4, [sp, #-4]!
    BL deleteChildrenStateRecursivelyRow_0
    ADD sp, sp, #4
    MOV r4, r0
    STRB r4, [sp]
    ADD sp, sp, #17
    MOV r0, #1
    POP {pc}
    .ltorg
deleteChildrenStateRecursivelyRow_0:
    PUSH {lr}
    SUB sp, sp, #17
    LDR r4, [sp, #21]
    MOV r0, r4
    BL p_check_null_ptr
    LDR r4, [r4]
    LDR r4, [r4]
    STR r4, [sp, #5]
    LDR r4, [sp, #5]
    MOV r0, r4
    BL p_check_null_ptr
    LDR r4, [r4]
    LDR r4, [r4]
    STR r4, [sp, #1]
    LDR r4, [sp, #5]
    MOV r0, r4
    BL p_check_null_ptr
    LDR r4, [r4, #4]
    LDR r4, [r4]
    STR r4, [sp, #13]
    LDR r4, [sp, #21]
    MOV r0, r4
    BL p_check_null_ptr
    LDR r4, [r4, #4]
    LDR r4, [r4]
    STR r4, [sp, #9]
    LDR r4, [sp, #1]
    STR r4, [sp, #-4]!
    BL deleteStateTreeRecursively_0
    ADD sp, sp, #4
    MOV r4, r0
    STRB r4, [sp]
    LDR r4, [sp, #13]
    STR r4, [sp, #-4]!
    BL deleteStateTreeRecursively_0
    ADD sp, sp, #4
    MOV r4, r0
    STRB r4, [sp]
    LDR r4, [sp, #9]
    STR r4, [sp, #-4]!
    BL deleteStateTreeRecursively_0
    ADD sp, sp, #4
    MOV r4, r0
    STRB r4, [sp]
    ADD sp, sp, #17
    MOV r0, #1
    POP {pc}
    .ltorg
askForAMove_0:
    PUSH {lr}
    LDRSB r4, [sp, #8]
    LDRSB r5, [sp, #9]
    CMP r4, r5
    MOVEQ r4, #1
    MOVNE r4, #0
    CMP r4, #0
    BEQ if_else_38
if_then_38:
    SUB sp, sp, #1
    LDR r4, [sp, #15]
    STR r4, [sp, #-4]!
    LDR r4, [sp, #9]
    STR r4, [sp, #-4]!
    BL askForAMoveHuman_0
    ADD sp, sp, #8
    MOV r4, r0
    STRB r4, [sp]
    ADD sp, sp, #1
    B if_end_38
if_else_38:
    SUB sp, sp, #1
    LDR r4, [sp, #15]
    STR r4, [sp, #-4]!
    LDR r4, [sp, #15]
    STR r4, [sp, #-4]!
    LDRSB r4, [sp, #18]
    STRB r4, [sp, #-1]!
    LDRSB r4, [sp, #18]
    STRB r4, [sp, #-1]!
    LDR r4, [sp, #15]
    STR r4, [sp, #-4]!
    BL askForAMoveAI_0
    ADD sp, sp, #14
    MOV r4, r0
    STRB r4, [sp]
    ADD sp, sp, #1
if_end_38:
    MOV r0, #1
    POP {pc}
    .ltorg
placeMove_0:
    PUSH {lr}
    SUB sp, sp, #4
    MOV r4, #0
    STR r4, [sp]
    LDR r4, [sp, #13]
    CMP r4, #2
    MOVLE r4, #1
    MOVGT r4, #0
    CMP r4, #0
    BEQ if_else_39
if_then_39:
    SUB sp, sp, #4
    LDR r4, [sp, #12]
    MOV r0, r4
    BL p_check_null_ptr
    LDR r4, [r4]
    LDR r4, [r4]
    STR r4, [sp]
    LDR r4, [sp, #17]
    CMP r4, #1
    MOVEQ r4, #1
    MOVNE r4, #0
    CMP r4, #0
    BEQ if_else_40
if_then_40:
    LDR r4, [sp]
    MOV r0, r4
    BL p_check_null_ptr
    LDR r4, [r4]
    LDR r4, [r4]
    STR r4, [sp, #4]
    B if_end_40
if_else_40:
    LDR r4, [sp]
    MOV r0, r4
    BL p_check_null_ptr
    LDR r4, [r4, #4]
    LDR r4, [r4]
    STR r4, [sp, #4]
if_end_40:
    ADD sp, sp, #4
    B if_end_39
if_else_39:
    LDR r4, [sp, #8]
    MOV r0, r4
    BL p_check_null_ptr
    LDR r4, [r4, #4]
    LDR r4, [r4]
    STR r4, [sp]
if_end_39:
    LDR r4, [sp, #17]
    CMP r4, #2
    MOVLE r4, #1
    MOVGT r4, #0
    CMP r4, #0
    BEQ if_else_41
if_then_41:
    SUB sp, sp, #4
    LDR r4, [sp, #4]
    MOV r0, r4
    BL p_check_null_ptr
    LDR r4, [r4]
    LDR r4, [r4]
    STR r4, [sp]
    LDR r4, [sp, #21]
    CMP r4, #1
    MOVEQ r4, #1
    MOVNE r4, #0
    CMP r4, #0
    BEQ if_else_42
if_then_42:
    LDRSB r4, [sp, #16]
    LDR r5, [sp]
    MOV r0, r5
    BL p_check_null_ptr
    LDR r5, [r5]
    STRB r4, [r5]
    B if_end_42
if_else_42:
    LDRSB r4, [sp, #16]
    LDR r5, [sp]
    MOV r0, r5
    BL p_check_null_ptr
    LDR r5, [r5, #4]
    STRB r4, [r5]
if_end_42:
    ADD sp, sp, #4
    B if_end_41
if_else_41:
    LDRSB r4, [sp, #12]
    LDR r5, [sp]
    MOV r0, r5
    BL p_check_null_ptr
    LDR r5, [r5, #4]
    STRB r4, [r5]
if_end_41:
    ADD sp, sp, #4
    MOV r0, #1
    POP {pc}
    .ltorg
notifyMove_0:
    PUSH {lr}
    LDRSB r4, [sp, #8]
    LDRSB r5, [sp, #9]
    CMP r4, r5
    MOVEQ r4, #1
    MOVNE r4, #0
    CMP r4, #0
    BEQ if_else_43
if_then_43:
    SUB sp, sp, #1
    LDR r4, [sp, #19]
    STR r4, [sp, #-4]!
    LDR r4, [sp, #19]
    STR r4, [sp, #-4]!
    LDR r4, [sp, #19]
    STR r4, [sp, #-4]!
    LDRSB r4, [sp, #22]
    STRB r4, [sp, #-1]!
    LDRSB r4, [sp, #22]
    STRB r4, [sp, #-1]!
    LDR r4, [sp, #19]
    STR r4, [sp, #-4]!
    BL notifyMoveAI_0
    ADD sp, sp, #18
    MOV r4, r0
    STRB r4, [sp]
    ADD sp, sp, #1
    B if_end_43
if_else_43:
    SUB sp, sp, #1
    LDR r4, [sp, #19]
    STR r4, [sp, #-4]!
    LDR r4, [sp, #19]
    STR r4, [sp, #-4]!
    LDRSB r4, [sp, #18]
    STRB r4, [sp, #-1]!
    LDRSB r4, [sp, #18]
    STRB r4, [sp, #-1]!
    LDR r4, [sp, #15]
    STR r4, [sp, #-4]!
    BL notifyMoveHuman_0
    ADD sp, sp, #14
    MOV r4, r0
    STRB r4, [sp]
    ADD sp, sp, #1
if_end_43:
    MOV r0, #1
    POP {pc}
    .ltorg
oppositeSymbol_0:
    PUSH {lr}
    LDRSB r4, [sp, #4]
    CMP r4, #120
    MOVEQ r4, #1
    MOVNE r4, #0
    CMP r4, #0
    BEQ if_else_44
if_then_44:
    MOV r0, #111
    POP {pc}
if_then_44_seq_0:
    B if_end_44
if_else_44:
    LDRSB r4, [sp, #4]
    CMP r4, #111
    MOVEQ r4, #1
    MOVNE r4, #0
    CMP r4, #0
    BEQ if_else_45
if_then_45:
    MOV r0, #120
    POP {pc}
if_then_45_seq_0:
    B if_end_45
if_else_45:
    LDR r4, =msg_36
    MOV r1, r4
    ADD r1, r1, #4
    LDR r0, =singleton_0
    ADD r0, r0, #4
    BL printf
    MOV r0, #0
    BL fflush
    LDR r4, =-1
    MOV r0, r4
    BL exit
if_end_45:
    
if_end_44:
    .ltorg
symbolAt_0:
    PUSH {lr}
    SUB sp, sp, #5
    MOV r4, #0
    STR r4, [sp, #1]
    LDR r4, [sp, #13]
    CMP r4, #2
    MOVLE r4, #1
    MOVGT r4, #0
    CMP r4, #0
    BEQ if_else_46
if_then_46:
    SUB sp, sp, #4
    LDR r4, [sp, #13]
    MOV r0, r4
    BL p_check_null_ptr
    LDR r4, [r4]
    LDR r4, [r4]
    STR r4, [sp]
    LDR r4, [sp, #17]
    CMP r4, #1
    MOVEQ r4, #1
    MOVNE r4, #0
    CMP r4, #0
    BEQ if_else_47
if_then_47:
    LDR r4, [sp]
    MOV r0, r4
    BL p_check_null_ptr
    LDR r4, [r4]
    LDR r4, [r4]
    STR r4, [sp, #5]
    B if_end_47
if_else_47:
    LDR r4, [sp]
    MOV r0, r4
    BL p_check_null_ptr
    LDR r4, [r4, #4]
    LDR r4, [r4]
    STR r4, [sp, #5]
if_end_47:
    ADD sp, sp, #4
    B if_end_46
if_else_46:
    LDR r4, [sp, #9]
    MOV r0, r4
    BL p_check_null_ptr
    LDR r4, [r4, #4]
    LDR r4, [r4]
    STR r4, [sp, #1]
if_end_46:
    MOV r4, #0
    STRB r4, [sp]
    LDR r4, [sp, #17]
    CMP r4, #2
    MOVLE r4, #1
    MOVGT r4, #0
    CMP r4, #0
    BEQ if_else_48
if_then_48:
    SUB sp, sp, #4
    LDR r4, [sp, #5]
    MOV r0, r4
    BL p_check_null_ptr
    LDR r4, [r4]
    LDR r4, [r4]
    STR r4, [sp]
    LDR r4, [sp, #21]
    CMP r4, #1
    MOVEQ r4, #1
    MOVNE r4, #0
    CMP r4, #0
    BEQ if_else_49
if_then_49:
    LDR r4, [sp]
    MOV r0, r4
    BL p_check_null_ptr
    LDR r4, [r4]
    LDRSB r4, [r4]
    STRB r4, [sp, #4]
    B if_end_49
if_else_49:
    LDR r4, [sp]
    MOV r0, r4
    BL p_check_null_ptr
    LDR r4, [r4, #4]
    LDRSB r4, [r4]
    STRB r4, [sp, #4]
if_end_49:
    ADD sp, sp, #4
    B if_end_48
if_else_48:
    LDR r4, [sp, #1]
    MOV r0, r4
    BL p_check_null_ptr
    LDR r4, [r4, #4]
    LDRSB r4, [r4]
    STRB r4, [sp]
if_end_48:
    LDRSB r4, [sp]
    ADD sp, sp, #5
    MOV r0, r4
    POP {pc}
    .ltorg
containEmptyCell_0:
    PUSH {lr}
    SUB sp, sp, #19
    LDR r4, [sp, #23]
    MOV r0, r4
    BL p_check_null_ptr
    LDR r4, [r4]
    LDR r4, [r4]
    STR r4, [sp, #8]
    LDR r4, [sp, #8]
    MOV r0, r4
    BL p_check_null_ptr
    LDR r4, [r4]
    LDR r4, [r4]
    STR r4, [sp, #15]
    LDR r4, [sp, #8]
    MOV r0, r4
    BL p_check_null_ptr
    LDR r4, [r4, #4]
    LDR r4, [r4]
    STR r4, [sp]
    LDR r4, [sp, #23]
    MOV r0, r4
    BL p_check_null_ptr
    LDR r4, [r4, #4]
    LDR r4, [r4]
    STR r4, [sp, #4]
    LDR r4, [sp, #15]
    STR r4, [sp, #-4]!
    BL containEmptyCellRow_0
    ADD sp, sp, #4
    MOV r4, r0
    STRB r4, [sp, #14]
    LDR r4, [sp]
    STR r4, [sp, #-4]!
    BL containEmptyCellRow_0
    ADD sp, sp, #4
    MOV r4, r0
    STRB r4, [sp, #13]
    LDR r4, [sp, #4]
    STR r4, [sp, #-4]!
    BL containEmptyCellRow_0
    ADD sp, sp, #4
    MOV r4, r0
    STRB r4, [sp, #12]
    LDRSB r4, [sp, #14]
    LDRSB r5, [sp, #13]
    ORR r4, r4, r5
    LDRSB r5, [sp, #12]
    ORR r4, r4, r5
    ADD sp, sp, #19
    MOV r0, r4
    POP {pc}
    .ltorg
containEmptyCellRow_0:
    PUSH {lr}
    SUB sp, sp, #7
    LDR r4, [sp, #11]
    MOV r0, r4
    BL p_check_null_ptr
    LDR r4, [r4]
    LDR r4, [r4]
    STR r4, [sp, #1]
    LDR r4, [sp, #1]
    MOV r0, r4
    BL p_check_null_ptr
    LDR r4, [r4]
    LDRSB r4, [r4]
    STRB r4, [sp]
    LDR r4, [sp, #1]
    MOV r0, r4
    BL p_check_null_ptr
    LDR r4, [r4, #4]
    LDRSB r4, [r4]
    STRB r4, [sp, #6]
    LDR r4, [sp, #11]
    MOV r0, r4
    BL p_check_null_ptr
    LDR r4, [r4, #4]
    LDRSB r4, [r4]
    STRB r4, [sp, #5]
    LDRSB r4, [sp]
    CMP r4, #0
    MOVEQ r4, #1
    MOVNE r4, #0
    LDRSB r5, [sp, #6]
    CMP r5, #0
    MOVEQ r5, #1
    MOVNE r5, #0
    ORR r4, r4, r5
    LDRSB r5, [sp, #5]
    CMP r5, #0
    MOVEQ r5, #1
    MOVNE r5, #0
    ORR r4, r4, r5
    ADD sp, sp, #7
    MOV r0, r4
    POP {pc}
    .ltorg
hasWon_0:
    PUSH {lr}
    SUB sp, sp, #9
    MOV r4, #1
    STR r4, [sp, #-4]!
    MOV r4, #1
    STR r4, [sp, #-4]!
    LDR r4, [sp, #21]
    STR r4, [sp, #-4]!
    BL symbolAt_0
    ADD sp, sp, #12
    MOV r4, r0
    STRB r4, [sp, #7]
    MOV r4, #2
    STR r4, [sp, #-4]!
    MOV r4, #1
    STR r4, [sp, #-4]!
    LDR r4, [sp, #21]
    STR r4, [sp, #-4]!
    BL symbolAt_0
    ADD sp, sp, #12
    MOV r4, r0
    STRB r4, [sp, #1]
    MOV r4, #3
    STR r4, [sp, #-4]!
    MOV r4, #1
    STR r4, [sp, #-4]!
    LDR r4, [sp, #21]
    STR r4, [sp, #-4]!
    BL symbolAt_0
    ADD sp, sp, #12
    MOV r4, r0
    STRB r4, [sp, #2]
    MOV r4, #1
    STR r4, [sp, #-4]!
    MOV r4, #2
    STR r4, [sp, #-4]!
    LDR r4, [sp, #21]
    STR r4, [sp, #-4]!
    BL symbolAt_0
    ADD sp, sp, #12
    MOV r4, r0
    STRB r4, [sp, #4]
    MOV r4, #2
    STR r4, [sp, #-4]!
    MOV r4, #2
    STR r4, [sp, #-4]!
    LDR r4, [sp, #21]
    STR r4, [sp, #-4]!
    BL symbolAt_0
    ADD sp, sp, #12
    MOV r4, r0
    STRB r4, [sp, #6]
    MOV r4, #3
    STR r4, [sp, #-4]!
    MOV r4, #2
    STR r4, [sp, #-4]!
    LDR r4, [sp, #21]
    STR r4, [sp, #-4]!
    BL symbolAt_0
    ADD sp, sp, #12
    MOV r4, r0
    STRB r4, [sp]
    MOV r4, #1
    STR r4, [sp, #-4]!
    MOV r4, #3
    STR r4, [sp, #-4]!
    LDR r4, [sp, #21]
    STR r4, [sp, #-4]!
    BL symbolAt_0
    ADD sp, sp, #12
    MOV r4, r0
    STRB r4, [sp, #8]
    MOV r4, #2
    STR r4, [sp, #-4]!
    MOV r4, #3
    STR r4, [sp, #-4]!
    LDR r4, [sp, #21]
    STR r4, [sp, #-4]!
    BL symbolAt_0
    ADD sp, sp, #12
    MOV r4, r0
    STRB r4, [sp, #3]
    MOV r4, #3
    STR r4, [sp, #-4]!
    MOV r4, #3
    STR r4, [sp, #-4]!
    LDR r4, [sp, #21]
    STR r4, [sp, #-4]!
    BL symbolAt_0
    ADD sp, sp, #12
    MOV r4, r0
    STRB r4, [sp, #5]
    LDRSB r4, [sp, #7]
    LDRSB r5, [sp, #17]
    CMP r4, r5
    MOVEQ r4, #1
    MOVNE r4, #0
    LDRSB r5, [sp, #1]
    LDRSB r6, [sp, #17]
    CMP r5, r6
    MOVEQ r5, #1
    MOVNE r5, #0
    AND r4, r4, r5
    LDRSB r5, [sp, #2]
    LDRSB r6, [sp, #17]
    CMP r5, r6
    MOVEQ r5, #1
    MOVNE r5, #0
    AND r4, r4, r5
    LDRSB r5, [sp, #4]
    LDRSB r6, [sp, #17]
    CMP r5, r6
    MOVEQ r5, #1
    MOVNE r5, #0
    LDRSB r6, [sp, #6]
    LDRSB r7, [sp, #17]
    CMP r6, r7
    MOVEQ r6, #1
    MOVNE r6, #0
    AND r5, r5, r6
    LDRSB r6, [sp]
    LDRSB r7, [sp, #17]
    CMP r6, r7
    MOVEQ r6, #1
    MOVNE r6, #0
    AND r5, r5, r6
    ORR r4, r4, r5
    LDRSB r5, [sp, #8]
    LDRSB r6, [sp, #17]
    CMP r5, r6
    MOVEQ r5, #1
    MOVNE r5, #0
    LDRSB r6, [sp, #3]
    LDRSB r7, [sp, #17]
    CMP r6, r7
    MOVEQ r6, #1
    MOVNE r6, #0
    AND r5, r5, r6
    LDRSB r6, [sp, #5]
    LDRSB r7, [sp, #17]
    CMP r6, r7
    MOVEQ r6, #1
    MOVNE r6, #0
    AND r5, r5, r6
    ORR r4, r4, r5
    LDRSB r5, [sp, #7]
    LDRSB r6, [sp, #17]
    CMP r5, r6
    MOVEQ r5, #1
    MOVNE r5, #0
    LDRSB r6, [sp, #4]
    LDRSB r7, [sp, #17]
    CMP r6, r7
    MOVEQ r6, #1
    MOVNE r6, #0
    AND r5, r5, r6
    LDRSB r6, [sp, #8]
    LDRSB r7, [sp, #17]
    CMP r6, r7
    MOVEQ r6, #1
    MOVNE r6, #0
    AND r5, r5, r6
    ORR r4, r4, r5
    LDRSB r5, [sp, #1]
    LDRSB r6, [sp, #17]
    CMP r5, r6
    MOVEQ r5, #1
    MOVNE r5, #0
    LDRSB r6, [sp, #6]
    LDRSB r7, [sp, #17]
    CMP r6, r7
    MOVEQ r6, #1
    MOVNE r6, #0
    AND r5, r5, r6
    LDRSB r6, [sp, #3]
    LDRSB r7, [sp, #17]
    CMP r6, r7
    MOVEQ r6, #1
    MOVNE r6, #0
    AND r5, r5, r6
    ORR r4, r4, r5
    LDRSB r5, [sp, #2]
    LDRSB r6, [sp, #17]
    CMP r5, r6
    MOVEQ r5, #1
    MOVNE r5, #0
    LDRSB r6, [sp]
    LDRSB r7, [sp, #17]
    CMP r6, r7
    MOVEQ r6, #1
    MOVNE r6, #0
    AND r5, r5, r6
    LDRSB r6, [sp, #5]
    LDRSB r7, [sp, #17]
    CMP r6, r7
    MOVEQ r6, #1
    MOVNE r6, #0
    AND r5, r5, r6
    ORR r4, r4, r5
    LDRSB r5, [sp, #7]
    LDRSB r6, [sp, #17]
    CMP r5, r6
    MOVEQ r5, #1
    MOVNE r5, #0
    LDRSB r6, [sp, #6]
    LDRSB r7, [sp, #17]
    CMP r6, r7
    MOVEQ r6, #1
    MOVNE r6, #0
    AND r5, r5, r6
    LDRSB r6, [sp, #5]
    LDRSB r7, [sp, #17]
    CMP r6, r7
    MOVEQ r6, #1
    MOVNE r6, #0
    AND r5, r5, r6
    ORR r4, r4, r5
    LDRSB r5, [sp, #2]
    LDRSB r6, [sp, #17]
    CMP r5, r6
    MOVEQ r5, #1
    MOVNE r5, #0
    LDRSB r6, [sp, #6]
    LDRSB r7, [sp, #17]
    CMP r6, r7
    MOVEQ r6, #1
    MOVNE r6, #0
    AND r5, r5, r6
    LDRSB r6, [sp, #8]
    LDRSB r7, [sp, #17]
    CMP r6, r7
    MOVEQ r6, #1
    MOVNE r6, #0
    AND r5, r5, r6
    ORR r4, r4, r5
    ADD sp, sp, #9
    MOV r0, r4
    POP {pc}
    .ltorg
allocateNewBoard_0:
    PUSH {lr}
    SUB sp, sp, #20
    BL allocateNewRow_0
    MOV r4, r0
    STR r4, [sp, #16]
    BL allocateNewRow_0
    MOV r4, r0
    STR r4, [sp]
    BL allocateNewRow_0
    MOV r4, r0
    STR r4, [sp, #4]
    MOV r0, #8
    BL malloc
    MOV r4, r0
    LDR r5, [sp, #16]
    MOV r0, #4
    BL malloc
    STR r5, [r0]
    STR r0, [r4]
    LDR r5, [sp]
    MOV r0, #4
    BL malloc
    STR r5, [r0]
    STR r0, [r4, #4]
    STR r4, [sp, #8]
    MOV r0, #8
    BL malloc
    MOV r4, r0
    LDR r5, [sp, #8]
    MOV r0, #4
    BL malloc
    STR r5, [r0]
    STR r0, [r4]
    LDR r5, [sp, #4]
    MOV r0, #4
    BL malloc
    STR r5, [r0]
    STR r0, [r4, #4]
    STR r4, [sp, #12]
    LDR r4, [sp, #12]
    ADD sp, sp, #20
    MOV r0, r4
    POP {pc}
    .ltorg
allocateNewRow_0:
    PUSH {lr}
    SUB sp, sp, #8
    MOV r0, #8
    BL malloc
    MOV r4, r0
    MOV r5, #0
    MOV r0, #1
    BL malloc
    STRB r5, [r0]
    STR r0, [r4]
    MOV r5, #0
    MOV r0, #1
    BL malloc
    STRB r5, [r0]
    STR r0, [r4, #4]
    STR r4, [sp]
    MOV r0, #8
    BL malloc
    MOV r4, r0
    LDR r5, [sp]
    MOV r0, #4
    BL malloc
    STR r5, [r0]
    STR r0, [r4]
    MOV r5, #0
    MOV r0, #1
    BL malloc
    STRB r5, [r0]
    STR r0, [r4, #4]
    STR r4, [sp, #4]
    LDR r4, [sp, #4]
    ADD sp, sp, #8
    MOV r0, r4
    POP {pc}
    .ltorg
freeBoard_0:
    PUSH {lr}
    SUB sp, sp, #17
    LDR r4, [sp, #21]
    MOV r0, r4
    BL p_check_null_ptr
    LDR r4, [r4]
    LDR r4, [r4]
    STR r4, [sp, #9]
    LDR r4, [sp, #9]
    MOV r0, r4
    BL p_check_null_ptr
    LDR r4, [r4]
    LDR r4, [r4]
    STR r4, [sp, #13]
    LDR r4, [sp, #9]
    MOV r0, r4
    BL p_check_null_ptr
    LDR r4, [r4, #4]
    LDR r4, [r4]
    STR r4, [sp, #1]
    LDR r4, [sp, #21]
    MOV r0, r4
    BL p_check_null_ptr
    LDR r4, [r4, #4]
    LDR r4, [r4]
    STR r4, [sp, #5]
    LDR r4, [sp, #13]
    STR r4, [sp, #-4]!
    BL freeRow_0
    ADD sp, sp, #4
    MOV r4, r0
    STRB r4, [sp]
    LDR r4, [sp, #1]
    STR r4, [sp, #-4]!
    BL freeRow_0
    ADD sp, sp, #4
    MOV r4, r0
    STRB r4, [sp]
    LDR r4, [sp, #5]
    STR r4, [sp, #-4]!
    BL freeRow_0
    ADD sp, sp, #4
    MOV r4, r0
    STRB r4, [sp]
    LDR r4, [sp, #9]
    MOV r0, r4
    BL p_free_pair
    LDR r4, [sp, #21]
    MOV r0, r4
    BL p_free_pair
    ADD sp, sp, #17
    MOV r0, #1
    POP {pc}
    .ltorg
freeRow_0:
    PUSH {lr}
    SUB sp, sp, #4
    LDR r4, [sp, #8]
    MOV r0, r4
    BL p_check_null_ptr
    LDR r4, [r4]
    LDR r4, [r4]
    STR r4, [sp]
    LDR r4, [sp]
    MOV r0, r4
    BL p_free_pair
    LDR r4, [sp, #8]
    MOV r0, r4
    BL p_free_pair
    ADD sp, sp, #4
    MOV r0, #1
    POP {pc}
    .ltorg
printAiData_0:
    PUSH {lr}
    SUB sp, sp, #9
    LDR r4, [sp, #13]
    MOV r0, r4
    BL p_check_null_ptr
    LDR r4, [r4]
    LDR r4, [r4]
    STR r4, [sp, #1]
    LDR r4, [sp, #13]
    MOV r0, r4
    BL p_check_null_ptr
    LDR r4, [r4, #4]
    LDR r4, [r4]
    STR r4, [sp, #5]
    LDR r4, [sp, #5]
    STR r4, [sp, #-4]!
    BL printStateTreeRecursively_0
    ADD sp, sp, #4
    MOV r4, r0
    STRB r4, [sp]
    MOV r0, #0
    BL exit
    .ltorg
printStateTreeRecursively_0:
    PUSH {lr}
    LDR r4, [sp, #4]
    CMP r4, #0
    MOVEQ r4, #1
    MOVNE r4, #0
    CMP r4, #0
    BEQ if_else_50
if_then_50:
    MOV r0, #1
    POP {pc}
if_then_50_seq_0:
    B if_end_50
if_else_50:
    SUB sp, sp, #17
    LDR r4, [sp, #21]
    MOV r0, r4
    BL p_check_null_ptr
    LDR r4, [r4]
    LDR r4, [r4]
    STR r4, [sp, #13]
    LDR r4, [sp, #13]
    MOV r0, r4
    BL p_check_null_ptr
    LDR r4, [r4]
    LDR r4, [r4]
    STR r4, [sp, #5]
    LDR r4, [sp, #13]
    MOV r0, r4
    BL p_check_null_ptr
    LDR r4, [r4, #4]
    LDR r4, [r4]
    STR r4, [sp, #1]
    LDR r4, [sp, #21]
    MOV r0, r4
    BL p_check_null_ptr
    LDR r4, [r4, #4]
    LDR r4, [r4]
    STR r4, [sp, #9]
    MOV r4, #118
    MOV r1, r4
    LDR r0, =singleton_1
    ADD r0, r0, #4
    BL printf
    MOV r0, #0
    BL fflush
    MOV r4, #61
    MOV r1, r4
    LDR r0, =singleton_1
    ADD r0, r0, #4
    BL printf
    MOV r0, #0
    BL fflush
    LDR r4, [sp, #9]
    MOV r1, r4
    LDR r0, =singleton_44
    ADD r0, r0, #4
    BL printf
    MOV r0, #0
    BL fflush
    LDR r4, [sp, #5]
    STR r4, [sp, #-4]!
    BL printBoard_0
    ADD sp, sp, #4
    MOV r4, r0
    STRB r4, [sp]
    LDR r4, [sp, #1]
    STR r4, [sp, #-4]!
    BL printChildrenStateTree_0
    ADD sp, sp, #4
    MOV r4, r0
    STRB r4, [sp]
    MOV r4, #112
    MOV r1, r4
    LDR r0, =singleton_18
    ADD r0, r0, #4
    BL printf
    MOV r0, #0
    BL fflush
    ADD sp, sp, #17
    MOV r0, #1
    POP {pc}
if_else_50_seq_0:
    ADD sp, sp, #17
if_end_50:
    .ltorg
printChildrenStateTree_0:
    PUSH {lr}
    SUB sp, sp, #17
    LDR r4, [sp, #21]
    MOV r0, r4
    BL p_check_null_ptr
    LDR r4, [r4]
    LDR r4, [r4]
    STR r4, [sp, #9]
    LDR r4, [sp, #9]
    MOV r0, r4
    BL p_check_null_ptr
    LDR r4, [r4]
    LDR r4, [r4]
    STR r4, [sp, #13]
    LDR r4, [sp, #9]
    MOV r0, r4
    BL p_check_null_ptr
    LDR r4, [r4, #4]
    LDR r4, [r4]
    STR r4, [sp, #1]
    LDR r4, [sp, #21]
    MOV r0, r4
    BL p_check_null_ptr
    LDR r4, [r4, #4]
    LDR r4, [r4]
    STR r4, [sp, #5]
    LDR r4, [sp, #13]
    STR r4, [sp, #-4]!
    BL printChildrenStateTreeRow_0
    ADD sp, sp, #4
    MOV r4, r0
    STRB r4, [sp]
    LDR r4, [sp, #1]
    STR r4, [sp, #-4]!
    BL printChildrenStateTreeRow_0
    ADD sp, sp, #4
    MOV r4, r0
    STRB r4, [sp]
    LDR r4, [sp, #5]
    STR r4, [sp, #-4]!
    BL printChildrenStateTreeRow_0
    ADD sp, sp, #4
    MOV r4, r0
    STRB r4, [sp]
    ADD sp, sp, #17
    MOV r0, #1
    POP {pc}
    .ltorg
printChildrenStateTreeRow_0:
    PUSH {lr}
    SUB sp, sp, #17
    LDR r4, [sp, #21]
    MOV r0, r4
    BL p_check_null_ptr
    LDR r4, [r4]
    LDR r4, [r4]
    STR r4, [sp, #5]
    LDR r4, [sp, #5]
    MOV r0, r4
    BL p_check_null_ptr
    LDR r4, [r4]
    LDR r4, [r4]
    STR r4, [sp, #1]
    LDR r4, [sp, #5]
    MOV r0, r4
    BL p_check_null_ptr
    LDR r4, [r4, #4]
    LDR r4, [r4]
    STR r4, [sp, #13]
    LDR r4, [sp, #21]
    MOV r0, r4
    BL p_check_null_ptr
    LDR r4, [r4, #4]
    LDR r4, [r4]
    STR r4, [sp, #9]
    LDR r4, [sp, #1]
    STR r4, [sp, #-4]!
    BL printStateTreeRecursively_0
    ADD sp, sp, #4
    MOV r4, r0
    STRB r4, [sp]
    LDR r4, [sp, #13]
    STR r4, [sp, #-4]!
    BL printStateTreeRecursively_0
    ADD sp, sp, #4
    MOV r4, r0
    STRB r4, [sp]
    LDR r4, [sp, #9]
    STR r4, [sp, #-4]!
    BL printStateTreeRecursively_0
    ADD sp, sp, #4
    MOV r4, r0
    STRB r4, [sp]
    ADD sp, sp, #17
    MOV r0, #1
    POP {pc}
    .ltorg
p_runtime_error:
    MOV r0, #-1
    BL exit
p_check_null_ptr:
    PUSH {lr}
    CMP r0, #0
    BNE not_null_0
p_check_null_ptr_seq_0:
    LDR r4, =msg_37
    MOV r1, r4
    ADD r1, r1, #4
    LDR r0, =singleton_0
    ADD r0, r0, #4
    BL printf
    MOV r0, #0
    BL fflush
    BL p_runtime_error
not_null_0:
    POP {pc}
p_check_arr_bound:
    PUSH {lr}
    CMP r0, #0
    BGE check_too_large_0
p_check_arr_bound_seq_0:
    LDR r4, =msg_38
    MOV r1, r4
    ADD r1, r1, #4
    LDR r0, =singleton_0
    ADD r0, r0, #4
    BL printf
    MOV r0, #0
    BL fflush
    BL p_runtime_error
check_too_large_0:
    LDR r1, [r1]
    CMP r0, r1
    BLT check_finish_0
check_too_large_0_seq_0:
    LDR r4, =msg_39
    MOV r1, r4
    ADD r1, r1, #4
    LDR r0, =singleton_0
    ADD r0, r0, #4
    BL printf
    MOV r0, #0
    BL fflush
    BL p_runtime_error
check_finish_0:
    POP {pc}
p_overflow_error:
    LDR r4, =msg_40
    MOV r1, r4
    ADD r1, r1, #4
    LDR r0, =singleton_0
    ADD r0, r0, #4
    BL printf
    MOV r0, #0
    BL fflush
    BL p_runtime_error
p_free_pair:
    PUSH {lr}
    BL p_check_null_ptr
    PUSH {r0}
    LDR r0, [r0]
    BL free
    LDR r0, [sp]
    LDR r0, [r0, #4]
    BL free
    POP {r0}
    BL free
    POP {pc}