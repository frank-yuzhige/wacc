# WACC Language spec

## Module and imports
```
module <Module Name> where
import <Module Name>;
...
endmodule
```

## Basic Syntax
#### constant value
```
const int x = 1;
const b = true;   #Defines a constant using type-inference.
```
#### function call
```
int x = f(1, f(3, g("foobar")));
```

## Type System

#### void function
```
void f(int x) is
    ...
    return;
end
```

#### newtype
```
newtype MyType is
    int x;
    char c;
    MyType child;
end

MyType a = new MyType(4, 'c', null);
MyType b = new MyType(x = 4, c = 'a', child = a);
a.x = 6;
a.child = a;
...
```

#### Type Inference
```
var x = 1;      // int
var b = x;      // int
var k = [x, b]; // int[]
...
```

#### Generics
```
newtype LinkedList<A> is
    A value;
    LinkedList<A> next;
end
```

#### Tagged Union
```
newtype Maybe<A> is union
    Nothing;
    Just of (A value);
end

newtype Either<A, B> is union
    Left  of (A value);
    Right of (B value);
end

newtype Tree<A> is union
    Leaf;
    Node of (Tree<A> left; A value; Tree<A> right);
```
Members of tagged-unions cannot be directly accessed via type member. 
e.g.```var x = Nothing(); var y = x.value;``` will throw a compile time error.

After the definition of each variable of a union type, it will have a "context".
A "context" indicates which union entry the variable has. Any attempt to access
a member of the variable which is under a wrong context will result in a compile
error.

```
newtype MaybeInt is union
    Nothing;
    Just of (int value);
end

MaybeInt x = Nothing();   # x : MaybeInt, is of "context" MaybeInt::Nothing
int tmp = x.value;        # compile time error. MaybeInt::Nothing does not have a member value.
MaybeInt y = Just(42);    # y : MaybeInt, is of "context" MaybeInt::Just
int tmp = y.value;        # OK, tmp = 42
```

Simple pattern matching with when-clause came to rescue!
When-clause decides the "context" of the matching object. In each case's block, the context will
be passed on.
```
int f(MaybeInt m) is
    int tmp = m.value;      # complie error, m: MaybeInt, yet we don't know its context.
    when m:               
        is Nothing -> int tmp = m.value;  # compile error, m is MaybeInt::Nothing
        is Just(x) -> int tmp = m.value;  # OK, tmp = fromJust(m)
    end;
    int tmp2 = m.value      # compile error, we do not know m's context now!
end


```

#### Traits, trait implementation and Type Constraints
```
trait A: Show is
    string show(A a) required
end

trait A: Eq is
    bool equals(A a, A b) required
    bool not_equals(A a, A b) is  # default function
        return !equals(a, b);
    end
end 

trait [A: Eq] => A: Ord is    # trait requires another trait
    Ordering compare(A a, A b) required
    bool gt(A a, A b) is
        return compare(a, b) == GT;
    end
    ...
end 

implement Ordering: Show is
    string show(Ordering x) is
        when x:
            is LT -> return "LT";
            is EQ -> return "EQ";
            is GT -> return "GT";
        end;
    end
end

instance [A: Eq] => List<A>: Eq is
    bool equals(List<A> l1, List<A> l2) is
        return if (l1 == null && l2 == null) then
            true
        elif (l1.value == l2.value) then
            equals(l1.next, l2.next)
        else 
            false
        fi;
    end
end
```

#### Simple Trait Derivation
```
newtype Ordering is union
    LT;
    EQ;
    GT;
end
deriving instance Ordering: Enum  
# automatically derives Eq, Ord, and Enum instance for Ordering
deriving instance Show: Enum
```
Derivable traits including ```Eq, Ord, Show, Enum```


## Control Flow

#### for-loop
```
for int i in 0..5 do
    ...
done;

for var j in 'A'..'Z' do
    ...
done;

for int k in 0..10 step 2 do
    ...
done;

```

#### foreach-loop
```
int[] arr = [1, 4, 5, 6]
foreach var x in arr do
    print x;
    print ",";  
done # 1,4,5,6,

List<Int> list = List.fromArray<Int>(arr)
foreach var x in list do
    print x;
    print ",";
done # 1,4,5,6,
```

#### conditional branch
```
if true then
    ...
fi;


if true then
    ...
else 
    ...
fi;

if true then
    ...
elif false then
    ...
fi;
```

#### ternary(X-nary) expression
```
var x = if true then 1 - 2 else 6 - 8 fi;
var y = if false then 'c' 
        elif true then 'k' 
        else 'c' 
        fi;
```

#### when-expression
```
Maybe<Int> x = Nothing;
when x:
    is Nothing -> println "Nothing";
    is Just(v) -> println v;
end;
```

