from typing import List, Tuple

import numpy as np


def define_triangle() -> Tuple[np.ndarray, np.ndarray, np.ndarray]:
    ### STUDENT CODE
    # TODO: Implement this function.

    # NOTE: The following lines can be removed. They prevent the framework
    #       from crashing.

    P1 = np.array([(1 + 4), -(1 + 1), -(1 + 8)])
    P2 = np.array([-(1 + 0), -(1 + 2), (1 + 6)])
    P3 = np.array([-(1 + 1), (1 + 8), -(1 + 2)])

    ### END STUDENT CODE

    return P1, P2, P3


def define_triangle_vertices(P1: np.ndarray, P2: np.ndarray, P3: np.ndarray) -> Tuple[
    np.ndarray, np.ndarray, np.ndarray]:
    ### STUDENT CODE
    # TODO: Implement this function.

    # NOTE: The following lines can be removed. They prevent the framework
    #       from crashing.

    P1P2 = np.subtract(P2, P1)
    P2P3 = np.subtract(P3, P2)
    P3P1 = np.subtract(P1, P3)
    ### END STUDENT CODE

    return P1P2, P2P3, P3P1


def compute_lengths(P1P2: np.ndarray, P2P3: np.ndarray, P3P1: np.ndarray) -> List[float]:
    ### STUDENT CODE
    # TODO: Implement this function.

    # NOTE: The following lines can be removed. They prevent the framework
    #       from crashing.

    norms = [0., 0., 0.]

    norms[0] = np.sqrt(P1P2[0] ** 2 + P1P2[1] ** 2 + P1P2[2] ** 2)
    norms[1] = np.sqrt(P2P3[0] ** 2 + P2P3[1] ** 2 + P2P3[2] ** 2)
    norms[2] = np.sqrt(P3P1[0] ** 2 + P3P1[1] ** 2 + P3P1[2] ** 2)

    ### END STUDENT CODE

    return norms


def compute_normal_vector(P1P2: np.ndarray, P2P3: np.ndarray, P3P1: np.ndarray) -> Tuple[np.ndarray, np.ndarray]:
    ### STUDENT CODE
    # TODO: Implement this function.

    # NOTE: The following lines can be removed. They prevent the framework
    #       from crashing.

    n = np.cross(P1P2, P3P1)
    n_normalized = np.dot(1 / np.linalg.norm(n), n)
    ### END STUDENT CODE

    return n, n_normalized


def compute_triangle_area(n: np.ndarray) -> float:
    ### STUDENT CODE
    # TODO: Implement this function.

    # NOTE: The following lines can be removed. They prevent the framework
    #       from crashing.

    area = 1 / 2 * np.linalg.norm(n)
    ### END STUDENT CODE

    return area


def compute_angles(P1P2: np.ndarray, P2P3: np.ndarray, P3P1: np.ndarray) -> Tuple[float, float, float]:
    ### STUDENT CODE
    # TODO: Implement this function.

    # NOTE: The following lines can be removed. They prevent the framework
    #       from crashing.

    alpha, beta, gamma = 0., 0., 0.

    alpha = np.arccos(np.dot(P1P2, -P3P1) / (np.linalg.norm(P3P1) * np.linalg.norm(P1P2)))
    beta = np.arccos(np.dot(P2P3, -P1P2) / (np.linalg.norm(P1P2) * np.linalg.norm(P2P3)))
    gamma = np.arccos(np.dot(P3P1, -P2P3) / (np.linalg.norm(P2P3) * np.linalg.norm(P3P1)))

    alpha = np.degrees(alpha)
    beta = np.degrees(beta)
    gamma = np.degrees(gamma)
    ### END STUDENT CODE

    return alpha, beta, gamma
