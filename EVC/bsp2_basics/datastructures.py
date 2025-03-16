from typing import Tuple
import numpy as np
from numpy import ndarray


def define_structures() -> Tuple[np.ndarray, np.ndarray, np.ndarray]:
    """
        Defines the two vectors v1 and v2 as well as the matrix M determined by your matriculation number.
    """
    ### STUDENT CODE
    # TODO: Implement this function.

    # NOTE: The following lines can be removed. They prevent the framework
    #       from crashing.

    v1 = np.array([1, 1, 4])
    v2 = np.array([8, 2, 8])
    M = np.array([[1, 2, 4], [2, 0, 1], [8, 6, 8]])

    ### END STUDENT CODE

    return v1, v2, M


def sequence(M: np.ndarray) -> np.ndarray:
    """
        Defines a vector given by the minimum and maximum digit of your matriculation number. Step size = 0.25.
    """
    ### STUDENT CODE
    # TODO: Implement this function.

    # NOTE: The following lines can be removed. They prevent the framework
    #       from crashing.
    step = 0.25
    result = np.arange(np.min(M), np.max(M) + step, step)
    ### END STUDENT CODE

    return result


def matrix(M: np.ndarray) -> np.ndarray:
    """
        Defines the 15x9 block matrix as described in the task description.
    """
    ### STUDENT CODE
    # TODO: Implement this function.

    # NOTE: The following lines can be removed. They prevent the framework
    #       from crashing.

    block1 = np.vstack((M, np.zeros((3, 3)), M, np.zeros((3, 3)), M))
    block2 = np.vstack((np.zeros((3, 3)), M, np.zeros((3, 3)), M, np.zeros((3, 3))))

    r = np.hstack((block1, block2, block1))

    ### END STUDENT CODE

    return r


def dot_product(v1: np.ndarray, v2: np.ndarray) -> float:
    """
        Dot product of v1 and v2.
    """
    ### STUDENT CODE
    # TODO: Implement this function.

    # NOTE: The following lines can be removed. They prevent the framework
    #       from crashing.

    r = 0

    for i in range(v1.size):
        r += v1[i] * v2[i]

    ### END STUDENT CODE

    return r


def cross_product(v1: np.ndarray, v2: np.ndarray) -> np.ndarray:
    """
        Cross product of v1 and v2.
    """
    ### STUDENT CODE
    # TODO: Implement this function.

    # NOTE: The following lines can be removed. They prevent the framework
    #       from crashing.

    r = np.zeros(v1.shape)
    lv = 1
    rv = 2

    for i in range(r.size):
        if lv == r.size:
            lv = 0
        elif rv == r.size:
            rv = 0
        r[i] = v1[lv] * v2[rv] - v1[rv] * v2[lv]
        lv += 1
        rv += 1
    ### END STUDENT CODE

    return r


def vector_X_matrix(v: np.ndarray, M: np.ndarray) -> np.ndarray:
    """
        Defines the vector-matrix multiplication v*M.
    """
    ### STUDENT CODE
    # TODO: Implement this function.

    # NOTE: The following lines can be removed. They prevent the framework
    #       from crashing.
    r = np.zeros((v.shape.__len__(), M[0].size))

    for rowR in range(r.shape[0]):
        j = 0
        for colR in range(r.shape[1]):
            for i in range(r.shape[1]):
                r[rowR][colR] += v[i] * M[i][j]
            j += 1

    ### END STUDENT CODE

    return r


def matrix_X_vector(M: np.ndarray, v: np.ndarray) -> np.ndarray:
    """
        Defines the matrix-vector multiplication M*v.
    """
    ### STUDENT CODE
    # TODO: Implement this function.

    # NOTE: The following lines can be removed. They prevent the framework
    #       from crashing.
    r = np.zeros((M[0].size, v.shape.__len__()))

    for rowR in range(r.shape[0]):
        for colR in range(r.shape[1]):
            for i in range(v.shape[0]):
                r[rowR][colR] += v[i] * M[rowR][i]

    ### END STUDENT CODE

    return r


def matrix_X_matrix(M1: np.ndarray, M2: np.ndarray) -> np.ndarray:
    """
        Defines the matrix multiplication M1*M2.
    """
    ### STUDENT CODE
    # TODO: Implement this function.

    # NOTE: The following lines can be removed. They prevent the framework
    #       from crashing.
    r = np.zeros((M1.shape[0], M2.shape[1]))

    for rowR in range(r.shape[0]):
        for colR in range(r.shape[1]):
            for i in range(r.shape[0]):
                r[rowR][colR] += M1[rowR][i] * M2[i][colR]

    ### END STUDENT CODE

    return r


def matrix_Xc_matrix(M1: np.ndarray, M2: np.ndarray) -> np.ndarray:
    """
        Defines the element-wise matrix multiplication M1*M2 (Hadamard Product).
    """
    ### STUDENT CODE
    # TODO: Implement this function.

    # NOTE: The following lines can be removed. They prevent the framework
    #       from crashing.
    r = np.zeros(M1.shape)

    for rowR in range(r.shape[0]):
        for colR in range(r.shape[1]):
            r[rowR][colR] = M1[rowR][colR] * M2[rowR][colR]

    ### END STUDENT CODE

    return r
