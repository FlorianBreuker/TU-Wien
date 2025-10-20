# Copyright TU Wien (2022) - EVC: Task5
# Institute of Computer Graphics and Algorithms.
from operator import truediv
from typing import List
import numpy as np

class ClippingPlane:

    def __init__(self, plane : np.ndarray):
        """ plane     ... plane stored in Hessian normal form as a 1x4 vector"""
        self.plane = plane
    
    def inside(self, pos : np.ndarray) -> bool:
        """Checks if a given point lies behind the plane (opposite direction
        of normal vector). Points lying on the plane are considered to be
        inside.
        position  ... homogeneous position with 4 components
        return res... logical value which indicates if the point is
                      inside or not """

        ### STUDENT CODE
        # TODO 2: Implement this function.
        # HINT:   You can access the plane property via self.plane.
        # NOTE:   The following lines can be removed. They prevent the framework
        #         from crashing.

        res = False

        if np.dot(pos, self.plane) <= 0:
            res = True


        ### END STUDENT CODE


        return res

    def intersect(self, pos1 : np.ndarray, pos2 : np.ndarray) -> float:
        """ Intersects the plane with a line between pos1 and pos2.
        pos1      ... homogeneous position with 4 components
        pos2      ... homogeneous position with 4 components
        return t  ... normalized intersection value t in [0, 1]"""

        ### STUDENT CODE
        # TODO 2: Implement this function.
        # HINT:   You can access the plane property via self.plane.
        # NOTE:   The following lines can be removed. They prevent the framework
        #         from crashing.

        la = np.dot(pos1, self.plane)
        lb = np.dot(pos2, self.plane)
        if la == lb: return la / 0.000001
        t = la / (la - lb)

        if self.inside(pos1):
            t -= 0.000001
        elif self.inside(pos2):
            t += 0.000001

        ### END STUDENT CODE

        return t
    
    @staticmethod
    def get_clipping_planes() -> List:
        """creates and returns a list of the six Clipping planes defined in the task description."""

        ### STUDENT CODE
        # TODO 2: Define the correct clip planes.
        # NOTE:   The following lines can be removed. They prevent the framework
        #         from crashing.

        res = [
            ClippingPlane(np.array([1, 0, 0, -1])),
            ClippingPlane(np.array([-1, 0, 0, -1])),
            ClippingPlane(np.array([0, 1, 0, -1])),
            ClippingPlane(np.array([0, -1, 0, -1])),
            ClippingPlane(np.array([0, 0, 1, -1])),
            ClippingPlane(np.array([0, 0, -1, -1]))
        ]

        ### END STUDENT CODE

        
        return res

