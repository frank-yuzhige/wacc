.data


.text

.global main
main:
    PUSH {lr}
    MOV r0, #0
    BL exit
    MOV r0, #0
    POP {pc}
    .ltorg
